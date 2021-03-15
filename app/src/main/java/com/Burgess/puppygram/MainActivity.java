package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button CreateNewButton;
    private Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateNewButton =(Button) findViewById(R.id.newAccount);
        LoginButton = (Button) findViewById(R.id.logIn);
        CreateNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewAccount();
            }
        });
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logintonew();
            }
        });

    }
    public void openNewAccount()
    {
        Intent intent = new Intent(this, NewAccount.class);
        startActivity(intent);

    }
    public void logintonew()
    {
        Intent intent = new Intent(this, Login.class );
        startActivity(intent);
    }

}