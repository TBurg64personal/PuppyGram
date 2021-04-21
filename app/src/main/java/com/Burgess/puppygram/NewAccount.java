package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class NewAccount extends AppCompatActivity {
    private Button NewAccount;
    private EditText fNameID;
    private EditText lNameID;
    private EditText EmailID;
    private EditText UserName;
    private  EditText password;
    private EditText password2;
    private String Emails;
    private String UserNames;
    private String Password1;
    private String Passwords;
    private String fname;
    private String lname;
    DatabaseHelper DatabaseHelp1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        NewAccount = (Button) findViewById(R.id.Submit);
        DatabaseHelp1 = new DatabaseHelper(this);
        NewAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                createNewAccount();
            }
        });
    }
    public void createNewAccount() {
        fNameID = (EditText)findViewById(R.id.firstNameInput);
        lNameID = (EditText)findViewById(R.id.lastNameInput);
        EmailID = (EditText)findViewById(R.id.emailInput);
        UserName = (EditText)findViewById(R.id.userNameInput);
        password= (EditText)findViewById(R.id.passwordOneInput);
        password2=(EditText)findViewById(R.id.passwordOneInput2);

        fname =fNameID.getText().toString();
        lname = lNameID.getText().toString();
        Emails = EmailID.getText().toString();
        UserNames= UserName.getText().toString();
        Password1 = password.getText().toString();
        Passwords = password2.getText().toString();
        boolean insertData = DatabaseHelp1.addData(fname,lname,Emails,Password1,UserNames);
        if(insertData&&(Password1.equals(Passwords)))
        {
            toastMessage("Data entered right");
        }
        else
        {
            toastMessage("Something went wrong");
        }
    }
    private void toastMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}