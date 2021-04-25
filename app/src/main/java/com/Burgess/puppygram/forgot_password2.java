package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class forgot_password2 extends AppCompatActivity {

    private Button GoBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password2);

        GoBackButton = (Button) findViewById(R.id.backToLogin);

        GoBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLogin();
            }
        });
    }
    
    public void backToLogin()
    {
        Intent intent = new Intent(this, Login.class );
        startActivity(intent);
    }
}