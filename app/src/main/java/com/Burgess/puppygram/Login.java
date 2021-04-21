package com.Burgess.puppygram;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    private Button loginButton;
    private Button forgotButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);
        loginButton = (Button) findViewById(R.id.logIn2);
        forgotButton = (Button) findViewById(R.id.forgotPass);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAccount();
            }
        });
        forgotButton.setOnClickListener(new View.OnClickListener()
        {
           @Override
           public void onClick(View v)
           {
               goToPassword();
           }
        });
    }
    public void CheckAccount()
    {
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }
    public void goToPassword()
    {
        Intent intent = new Intent(this, forgot_password1.class);
        startActivity(intent);
    }
}