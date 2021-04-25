package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgot_password2 extends AppCompatActivity {

    private Button GoBackButton;
    private EditText Password1;
    private EditText Password2;
    DatabaseHelper data;
    String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password2);
        Password1 = findViewById(R.id.updatePass1);
        Password2 = findViewById(R.id.updatePass2);
        data = new DatabaseHelper();
        GoBackButton = (Button) findViewById(R.id.backToLogin);
        Intent intent = getIntent();
        Email = intent.getExtras().getString("Email");
        //toastMessage(Email);

        GoBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLogin();
            }
        });
    }
    
    public void backToLogin()
    {

        data.changePassword(Password1.toString(), Password2.toString(), Email);
        //Intent intent = new Intent(this, Login.class );
        //startActivity(intent);
    }
    private void toastMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}