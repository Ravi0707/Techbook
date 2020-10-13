package com.example.techbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class Login extends AppCompatActivity {

    private EditText text_email;
    private EditText text_password;
    private Button btn_login;
    private FirebaseAuth auth;
    private TextView mRecoverPassTv, loginTextview;
    ProgressDialog progressDialog;


    public void login(View view){
        if(!isDataValid()){
            return;
        }


        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Logging in");
        progressDialog.show();

        String email = text_email.getText().toString();
        String password = text_password.getText().toString();

        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful() ){
                            Log.d("result","SigninWithEmail: Success");

                            new android.os.Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    FirebaseUser user = auth.getCurrentUser();
                                    updateUI(user);
                                    progressDialog.dismiss();
                                }
                            },1500);
                        }else{
                            new android.os.Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d("result","SigninWithEmail: Failed");
                                    Toast.makeText(Login.this,"Invalid username or Password",Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                }
                            },1000);
                        }
                    }
                });
    }

    public void updateUI(FirebaseUser user){
        String name = user.getEmail();
        Intent intent = new Intent(Login.this, DashBoardActivity.class);
        startActivity(intent);
        finish();
        //Toast.makeText(getApplicationContext(),"Welcome! " +name,Toast.LENGTH_SHORT).show();
    }

    public boolean isDataValid(){

        boolean valid = true;

        String email = text_email.getText().toString();
        String password = text_password.getText().toString();

        if( email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches() ){
            text_email.setError("enter valid email address");
            valid = false;
        }else text_email.setError(null);

        if(password.isEmpty() || password.length() < 5 || password.length() > 15) {
            text_password.setError("between 5 and 15 alphanumeric characters");
            valid = false;
        } else text_password.setError(null);

        return valid;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_email = findViewById(R.id.email);
        text_password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        loginTextview = findViewById(R.id.loginTextview);
        mRecoverPassTv = findViewById(R.id.recoverPassTv);

        auth = FirebaseAuth.getInstance();

        text_password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    login(v);
                }
                return false;
            }
        });

        //not have account textview click listener
        loginTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
                finish();
            }
        });

        //recover password action listener
        mRecoverPassTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRecoverPasswordDialog();
            }
        });

        //init progress dialog
        progressDialog = new ProgressDialog(this);
    }

    private void showRecoverPasswordDialog() {
    //Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Recover Password");

        //set layout Linear layout
        LinearLayout linearLayout = new LinearLayout(this);

        //views to set in dialog
        final EditText emailRecovery  = new EditText(this);
        emailRecovery.setHint("Email");
        emailRecovery.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        //sets min width of editview
        emailRecovery.setMinEms(16);

        linearLayout.addView(emailRecovery);
        linearLayout.setPadding(10, 10, 10, 10);
        builder.setView(linearLayout);

        //buttons recover
        builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //input email
                String email= emailRecovery.getText().toString().trim();
                beingRecovery(email);
            }
        });

        //buttons cancel
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //dismiss dialog
                dialogInterface.dismiss();
            }
        });

        //show dialog
        builder.create().show();
    }

    private void beingRecovery(String email) {
        //show progress dialog
        progressDialog.setMessage("Sending Email...");
        progressDialog.show();

        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            Toast.makeText(Login.this,"Email Sent",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Login.this,"Failed...",Toast.LENGTH_SHORT).show();

                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                //get and show proper error message
                Toast.makeText(Login.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}