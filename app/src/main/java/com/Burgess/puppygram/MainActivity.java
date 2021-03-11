package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button CreateNewButton;
    private Button NewAccount;
    private EditText fName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateNewButton =(Button) findViewById(R.id.newAccount);
        CreateNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewAccount();
            }
        });
        NewAccount = (Button) findViewById(R.id.Submit);
        NewAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                fName = (EditText)findViewById(R.id.firstNameInput);
            }
        });
    }
    public void openNewAccount()
    {
        Intent intent = new Intent(this, NewAccount.class);
        startActivity(intent);

    }
}