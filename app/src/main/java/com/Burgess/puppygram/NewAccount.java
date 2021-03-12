package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

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
    private String fname;
    private String lname;
    public Connection conn;

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
        conn = connectionClass();

        fNameID = (EditText)findViewById(R.id.firstNameInput);
        lNameID = (EditText)findViewById(R.id.lastNameInput);
        fname =fNameID.getText().toString();
        lname = lNameID.getText().toString();


    }
    public Connection connectionClass()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://puppygram.database.windows.net:1433;DatabaseName=Puppygram;user=Noahkrill@puppygram;password=Uakron2019;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            connection = DriverManager.getConnection(ConnectionURL);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}