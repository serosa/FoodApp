package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {
    private EditText inputUsername,inputEmail,inputPassword,inputConformPassword;
    Button btnRegiter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        TextView btn = findViewById(R.id.alreadyHaveAccount);
        inputUsername = findViewById(R.id.inputUsername);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConformPassword = findViewById(R.id.inputConformPassword);

        btnRegiter = findViewById(R.id.btnRegister);
        btnRegiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCrededentials();

            }
        });





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegActivity.this,LogActivity.class));
            }
        });
    }

    private void checkCrededentials() {
            String  username = inputUsername.getText().toString();
            String email = inputEmail.getText().toString();
            String password = inputPassword.getText().toString();
            String conformpassword = inputConformPassword.getText().toString();

            if (username.isEmpty() || username.length() < 7){
                showError(inputUsername,"your username is not valid!");
            }
            else if (email.isEmpty() || !email.contains("@")){
                showError(inputEmail,"email is not valid");
            }
            else if (password.isEmpty() || password.length() <7){
                showError(inputPassword,"Password must be 7 character");
            }
            else if(conformpassword.isEmpty() || !conformpassword.equals(password)){
                showError(inputConformPassword,"Password not match");
            }
            else{
                Toast.makeText(this,"Call Registration Method",Toast.LENGTH_SHORT).show();
            }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}