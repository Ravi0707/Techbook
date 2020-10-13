package com.example.techbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class AskQuestion extends AppCompatActivity {
    private EditText text_question, text_topic;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);

        text_question = findViewById(R.id.text_question);
        text_topic = findViewById(R.id.text_topic);

        Button ask_question = findViewById(R.id.btn_ask_question);

        progressDialog = new ProgressDialog(this,
                R.style.Theme_AppCompat_Light_Dialog);


        ask_question.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Uploading your Question...");
                progressDialog.show();

                final String timeStamp = String.valueOf(System.currentTimeMillis());

                String title = text_topic.getText().toString().trim();
                String question = text_question.getText().toString().trim();

                if (question.isEmpty() && title.isEmpty()) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Invalid Question", Toast.LENGTH_SHORT).show();
                }
                else {
                    Database db = new Database();
                    Task<Void> result = db.uploadQuestion(question, title);
                    result.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "upload failed", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}