package com.example.techbook.ui.main.fragments.profile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.techbook.R;
import com.example.techbook.data.CurrentUser;
import com.example.techbook.data.CurrentUserInfoHolder;
import com.example.techbook.database.Database;
import com.example.techbook.ui.main.MainActivity;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class ProfileFragment extends Fragment {
    private TextView name, email;
    private ImageView profileImage, profilePlaceholder;
    LinearLayout imageLayout;
    private StorageReference storage;
    private ProgressDialog progressDialog;
    private Database database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.userName);
        email = view.findViewById(R.id.userEmail);
        profileImage = view.findViewById(R.id.userProfileImageView);
        profilePlaceholder = view.findViewById(R.id.imageProfilePlaceholder);
        imageLayout = view.findViewById(R.id.profileImageViewLayout);

        storage = FirebaseStorage.getInstance().getReference();

        progressDialog = new ProgressDialog(requireContext(),
                R.style.Theme_AppCompat_Light_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Updating your profile picture...");


        imageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGallery, 1000);
            }
        });
        updateUserInfo();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {

                final String[] downloadUrl = new String[1];
                progressDialog.show();
                assert data != null;
                Uri imageUri = data.getData();

                final StorageReference storageReference = storage.child("users/" + CurrentUserInfoHolder.getInstance().getItem().getuId() + "/profile.jpg");

                UploadTask uploadTask = storageReference.putFile(imageUri);

                uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw Objects.requireNonNull(task.getException());
                        }
                        // Continue with the task to get the download URL
                        return storageReference.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            Uri downloadUri = task.getResult();
                            assert downloadUri != null;
                            try {
                                downloadUrl[0] = downloadUri.toString();
                                database = new Database();
                                DocumentReference userData = database.getUserData();
                                userData.update("Image", downloadUrl[0]).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        ((MainActivity) requireActivity()).getUserData();
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                updateUserInfo();
                                                progressDialog.dismiss();
                                                Toast.makeText(requireContext(), "Successfully updated profile picture", Toast.LENGTH_SHORT).show();

                                            }
                                        }, 2000);
                                          }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        progressDialog.dismiss();
                                        Toast.makeText(requireContext(), "Failed updating profile picture", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } catch (Exception e) {
                                progressDialog.dismiss();
                                Log.e("IMAGE UPLOAD", Objects.requireNonNull(e.getMessage()));
                            }

                        } else {
                            progressDialog.dismiss();
                            Log.e("IMAGE UPLOAD", "Error getting image url");
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(requireContext(), "Failed updating profile picture", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    public void updateUserInfo() {
        CurrentUser user = CurrentUserInfoHolder.getInstance().getItem();
        name.setText(user.getUsername());
        email.setText(user.getUserEmail());

        if (user.getUserImage() != null) {
            profileImage.setVisibility(View.VISIBLE);
            profilePlaceholder.setVisibility(View.GONE);
            Picasso.get().load(user.getUserImage()).into(profileImage);
        } else {
            profileImage.setVisibility(View.GONE);
            profilePlaceholder.setVisibility(View.VISIBLE);
        }
    }
}