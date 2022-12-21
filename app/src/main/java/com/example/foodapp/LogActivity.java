package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity {
    private TextView logo;
 EditText inputEmail , inputPassword;
 Button btnLogin;
 Animation anim;
 private Animation top_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        logo = findViewById(R.id.logo);
        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        logo.setAnimation(top_anim);
        TextView btn = findViewById(R.id.txtsignup);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCrededentials();

            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogActivity.this,RegActivity.class));
            }
        });
    }
    private void checkCrededentials() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();


       if (email.isEmpty() || !email.contains("@")){
            showError(inputEmail,"email is not valid");
        }
        else if (password.isEmpty() || password.length() <7){
            showError(inputPassword,"Password must be 7 character");
        }

        else{
            Toast.makeText(this,"Call Login Method",Toast.LENGTH_SHORT).show();
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}