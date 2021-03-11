package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewAccount extends AppCompatActivity {
    private Button NewAccount;
    private EditText fNameID;
    private EditText lNameID;
    private String fname;
    private String lname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        NewAccount = (Button) findViewById(R.id.Submit);

        NewAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                createNewAccount();
            }
        });
    }
    public void createNewAccount()
    {
        fNameID = (EditText)findViewById(R.id.firstNameInput);
        lNameID = (EditText)findViewById(R.id.lastNameInput);
        fname =fNameID.getText().toString();
        lname = lNameID.getText().toString();

    }
}