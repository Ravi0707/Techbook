package com.example.techbook.database;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.techbook.data.CurrentUser;
import com.example.techbook.data.CurrentUserInfoHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class Database {
    private final FirebaseFirestore firestoreDB;
    private final StorageReference storage;
    private final String currentUserId;
    private final CurrentUser user = CurrentUserInfoHolder.getInstance().getItem();

    public Database() {
        firestoreDB = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        firestoreDB.setFirestoreSettings(settings);

        storage = FirebaseStorage.getInstance().getReference();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        currentUserId = Objects.requireNonNull(auth.getCurrentUser()).getUid();
    }

    public FirebaseFirestore getDb() {
        return firestoreDB;
    }

    public void registerUser(final String userId, final String name, final String email) {
        DocumentReference document = firestoreDB.collection("users").document(userId);
        Map<String, Object> users = new HashMap<>();
        users.put("Name", name);
        users.put("Email", email);
        document.set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "User profile created for " + userId);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "Cannot create user profile create" + e.toString());
            }
        });

    }

    public DocumentReference getUserData() {
        return firestoreDB.collection("users").document(currentUserId);
    }

    public Task<Void> uploadQuestion(String question, String title) {
        DocumentReference questionDocument = firestoreDB.collection("Questions").document(question);
        HashMap<String, String> file = new HashMap<>();
        file.put("title", title);
        file.put("question", question);
        file.put("Uploader", CurrentUserInfoHolder.getInstance().getItem().getUsername());
        file.put("date", String.valueOf(System.currentTimeMillis()));

        return questionDocument.set(file);
    }

    public Task<Void> uploadAnswer(String question, String answer) {
        DocumentReference quesRef = firestoreDB.collection("Questions").document(question);
        Map<String, Object> ans = new HashMap<>();
        ans.put("question", question);
        ans.put("answer", answer);
        ans.put("Uploader", user.getUsername());

        return quesRef.update(ans);
    }

    public Uri getProfilePictureUrl() {
        StorageReference profileRef = storage.child("users/" + currentUserId + "/profile.jpg");
        final Uri[] imageUri = new Uri[1];

        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Log.d("PROFILE", "success" + uri.toString());
                imageUri[0] = uri;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("PROFILE", Objects.requireNonNull(e.getLocalizedMessage()));
            }
        })
                .addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        Log.d("PROFILE", "success" + task.getResult().getPath());
                    }
                });
        return imageUri[0];
    }
}
