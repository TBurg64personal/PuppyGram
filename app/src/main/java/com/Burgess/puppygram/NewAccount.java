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
    public Connection conn;
    private Statement stmt = null;
    private boolean isAccount = false;


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
        try {
            if(Password1.equals(Passwords)) {
                isAccount = testEmail();
                if (isAccount==false) {
                    stmt = conn.createStatement();
                    String sql = "INSERT INTO AccountTable " + "VALUES ('" + fname + "' , '" + lname + "' , '" + Emails + "' , '" + Passwords + "' , '" + UserNames + "')";
                    stmt.executeUpdate(sql);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()) ;
        }
    }
    private boolean testEmail()
    {
        conn = connectionClass();
        try {
                stmt = conn.createStatement();
                String sql = "SELECT COUNT(Email) FROM AccountTable " + "WHERE Email = '"+ Emails +"'";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                int count = rs.getInt(1);
                if(count==0)
                {
                    return false;
                }
            }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return true;
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