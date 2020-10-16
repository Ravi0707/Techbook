package com.example.techbook.ui.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.techbook.ui.login.LoginActivity;
import com.example.techbook.R;
import com.example.techbook.ui.register.RegisterActivity;

public class Welcome extends AppCompatActivity {
    Button mRegisterBtn, mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mRegisterBtn=findViewById(R.id.register_btn);
        mLoginBtn=findViewById(R.id.login_btn);

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start register activity
                startActivity(new Intent(Welcome.this, RegisterActivity.class));

            }
        });

        //handle login button
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Welcome.this, LoginActivity.class));
            }
        });

    }
}