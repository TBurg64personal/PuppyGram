package com.Burgess.puppygram;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class Login extends AppCompatActivity {
    private Button loginButton;
    DatabaseHelper helper1;
    EditText user;
    EditText Pass;
    String UserString ="";
    String PassString = "";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_login);
        user = (EditText)findViewById(R.id.userNameLog);
        Pass =(EditText)findViewById(R.id.PasswordLog);
        loginButton = (Button) findViewById(R.id.logIn2);
        helper1 = new DatabaseHelper();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CheckAccount();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
    public void CheckAccount() throws SQLException {
        int find=0;
          UserString = user.getText().toString();
          PassString = Pass.getText().toString();
          find = helper1.checkAccount2(UserString,PassString);
          if(find==1)
          {
              toastMessage("Found the account");
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