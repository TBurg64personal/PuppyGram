package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class forgot_password1 extends AppCompatActivity {

    private Button VerifyButton;
    private Button GoBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password1);

        VerifyButton = (Button) findViewById(R.id.verify);
        GoBackButton = (Button) findViewById(R.id.back);

        VerifyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openPassword2();
            }
        });
        GoBackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                backToLogin();
            }
        });
    }

    public void openPassword2()
    {
        Intent intent = new Intent(this, forgot_password2.class);
        startActivity(intent);
    }
    public void backToLogin()
    {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}