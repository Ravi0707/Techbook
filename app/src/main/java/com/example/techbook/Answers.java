package com.example.techbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class Answers extends AppCompatActivity {
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        final TextView text_answer = findViewById(R.id.text_answer);
        TextView text_question = findViewById(R.id.text_question);
        Button submit = findViewById(R.id.btn_submit);

        progressDialog = new ProgressDialog(this,
                R.style.Theme_AppCompat_Light_Dialog);

        text_question.setText(Feed.question);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Uploading...");
                progressDialog.show();

                final String answer = text_answer.getText().toString().trim();
                if (answer.isEmpty()) {
                    Log.i("Null answer", "true " + answer);
                    return;
                } else {
                    Task<Void> task = Feed.database.uploadAnswer(Feed.question, answer);
                    task.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Successfully Added", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
