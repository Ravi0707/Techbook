package com.example.techbook.ui.register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.techbook.R;
import com.example.techbook.database.Database;
import com.example.techbook.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_register;
    private EditText text_name;
    private EditText text_email;
    private EditText text_password;
    private EditText text_confirmPassword;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        text_name = findViewById(R.id.text_name);
        text_email = findViewById(R.id.text_email);
        text_password = findViewById(R.id.text_password);
        text_confirmPassword = findViewById(R.id.text_confirmPassword);
        btn_register = findViewById(R.id.btn_register);
        TextView loginTextView = findViewById(R.id.loginTextView);

        auth = FirebaseAuth.getInstance();

        text_confirmPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    onRegister();
                }
                return false;
            }
        });

        //handle login text view click listener
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegister();
            }
        });
    }

    public void onRegister() {

        if (isDataValid()) {
            btn_register.setEnabled(false);

            final ProgressDialog progressDialog = new ProgressDialog(this,
                    R.style.Theme_AppCompat_Light_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Creating Account");
            progressDialog.show();


            final String email = text_email.getText().toString().trim();
            final String password = text_password.getText().toString().trim();
            final String name = text_name.getText().toString();

            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(RegisterActivity.this, "Register Success.", Toast.LENGTH_SHORT).show();
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("Registration Result", "createUserWithEmail:success");
                                //Stores the Registered user Data
                                progressDialog.setMessage("Signing In...");
                                if (auth.getCurrentUser() != null) {
                                    auth.signOut();
                                }
                                signIn();


                            } else {
                                progressDialog.dismiss();
                                // If sign in fails, display a message to the user.
                                btn_register.setEnabled(true);
                                Log.w("Registration Result", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(RegisterActivity.this, "Register failed.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        private void signIn() {
                            auth.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                Log.d("result", "SignIn With Email Success");
                                                progressDialog.dismiss();
                                                FirebaseUser user = auth.getCurrentUser();
                                                assert user != null;
                                                new Database().registerUser(user.getUid(), name, email);

                                                auth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        Toast.makeText(RegisterActivity.this, "Verification email sent. Verify email before logging in.", Toast.LENGTH_LONG).show();
                                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                                        startActivity(intent);
                                                        finish();
                                                    }
                                                })
                                                        .addOnFailureListener(new OnFailureListener() {
                                                            @Override
                                                            public void onFailure(@NonNull Exception e) {
                                                                Toast.makeText(RegisterActivity.this, "Failed to send verification email.Try again", Toast.LENGTH_SHORT).show();

                                                            }
                                                        });
//

                                            } else {
                                                btn_register.setEnabled(true);
                                                Log.d("result", "SigninWithEmail: Failed");
                                                Toast.makeText(RegisterActivity.this, "Invalid username or Password", Toast.LENGTH_SHORT).show();
                                                progressDialog.dismiss();
                                            }
                                        }
                                    });
                        }
                    });
        }
    }

    public boolean isDataValid() {

        String name = text_name.getText().toString().trim();
        String email = text_email.getText().toString().trim();
        String password = text_password.getText().toString().trim();
        String confirmPassword = text_confirmPassword.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3) {
            text_name.setError("at least 3 characters");
            return false;
        } else if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            text_email.setError("enter valid email address");
            return false;
        } else if (password.isEmpty() || password.length() < 5 || password.length() > 15 || !password.equals(confirmPassword)) {
            if (!password.equals(confirmPassword)) {
                text_password.setError("Password does not match");
            } else {
                text_password.setError("between 5 and 15 alphanumeric characters");
            }
            return false;

        } else
            return true;
    }
}
