package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SymbolTable;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class NewAccount extends AppCompatActivity {
    private Button NewAccount;
    private EditText fNameID;
    private EditText lNameID;
    private EditText EmailID;
    private EditText UserName;
    private  EditText password;
    private EditText password2;
    DatabaseHelper data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        NewAccount = (Button) findViewById(R.id.Submit);
        data = new DatabaseHelper();

        NewAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                fNameID = (EditText)findViewById(R.id.firstNameInput);
                lNameID = (EditText)findViewById(R.id.lastNameInput);
                EmailID = (EditText)findViewById(R.id.emailInput);
                UserName = (EditText)findViewById(R.id.userNameInput);
                password= (EditText)findViewById(R.id.passwordOneInput);
                password2=(EditText)findViewById(R.id.passwordOneInput2);
                data.createNewAccount(fNameID,lNameID, EmailID, UserName, password, password2);
                data.setNull(UserName.getText().toString());
                Intent intent = new Intent(v.getContext(), new_account2.class);
                intent.putExtra("Username", UserName.getText().toString());
                startActivity(intent);
            }
        });
    }

}