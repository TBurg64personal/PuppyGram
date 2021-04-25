package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgot_password1 extends AppCompatActivity {

    private Button VerifyButton;
    private Button GoBackButton;
    private EditText userName, email;
    DatabaseHelper data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password1);
        userName = findViewById(R.id.usernameVerify);
        email = findViewById(R.id.emailVerify);
        data = new DatabaseHelper();


        VerifyButton = (Button) findViewById(R.id.verify);
        GoBackButton = (Button) findViewById(R.id.back);

        VerifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPassword2();
            }
        });
        GoBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLogin();
            }
        });
    }

    public void openPassword2() {
        String User = userName.getText().toString();
        String getEmail = email.getText().toString();
        boolean isAccount = false;
        isAccount = data.checkAccountForResetPassword(User,getEmail);
        //(Boolean.toString(isAccount));
        if(isAccount)
        {
            Intent intent = new Intent(this, forgot_password2.class);
            startActivity(intent);
        }
        else
        {
            toastMessage("Something was entered wrong");
        }
    }

    public void backToLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    private void toastMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
