package com.example.techbook.ui.main.fragments.profile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.techbook.R;
import com.example.techbook.data.CurrentUserInfoHolder;
import com.example.techbook.database.Database;
import com.example.techbook.ui.main.MainActivity;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.squareup.picasso.Picasso;

import javax.annotation.Nullable;

public class ProfileFragment extends Fragment {
    private TextView textName;
    private TextView textEmail;
    private ImageView profileImage;
    private Database database;
    private ProgressDialog progressDialog;


    @Override
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        database = new Database();

        textName = view.findViewById(R.id.textName);
        textEmail = view.findViewById(R.id.textEmail);
        TextView text_editImage = view.findViewById(R.id.text_editImage);
        profileImage = view.findViewById(R.id.image_profile);


        text_editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGallery, 1000);
            }
        });
        progressDialog = new ProgressDialog(getContext(), R.style.Theme_AppCompat_Light_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Updating");
        progressDialog.show();

        showUser();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {

                progressDialog.show();

                assert data != null;
                Uri imageUri = data.getData();
                database.uploadProfilePic(imageUri);
                Picasso.get().load(CurrentUserInfoHolder.getInstance().getItem().getUserImage()).into(profileImage);
                ((MainActivity) requireActivity()).getUserData();
                Toast.makeText(getContext(), "Profile picture updated", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public void showUser() {
        try {
            DocumentReference docRef = database.getUserData();
            docRef.addSnapshotListener(requireActivity(), new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                    assert documentSnapshot != null;
                    textName.setText(documentSnapshot.getString("Name"));
                    textEmail.setText(documentSnapshot.getString("Email"));

                }
            });
        } catch (Exception f) {
            Log.d("Error", "" + f);
        }
    }
}