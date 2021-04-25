package com.Burgess.puppygram;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.os.StrictMode;
import android.util.Log;
import android.widget.EditText;
import android.widget.TableRow;

import androidx.annotation.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private String Emails;
    private String UserNames;
    private String Password;
    private String Password2;
    private String fname;
    private String lname;
    public Connection conn;
    private Statement stmt = null;

    private boolean isAccount = false;
    private boolean isUserName = false;
    String User123;

    public void createNewAccount(EditText fNameID,EditText lNameID, EditText EmailID, EditText UserName,EditText password, EditText password2 )
    {
        conn = connectionClass();

        fname =fNameID.getText().toString();
        lname = lNameID.getText().toString();
        Emails = EmailID.getText().toString();
        UserNames= UserName.getText().toString();
        Password = password.getText().toString();
        Password2 = password2.getText().toString();
        try {
            if(Password.equals(Password2)) {
                isAccount = testEmail();
                isUserName = testUserName();
                if (isAccount==false && isUserName==false ) {
                    stmt = conn.createStatement();
                    String sql = "INSERT INTO AccountTable " + "VALUES ('" + fname + "' , '" + lname + "' , '" + Emails + "' , '" + Password + "' , '" + UserNames + "')";
                    stmt.executeUpdate(sql);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()) ;
        }
    }
    private boolean testUserName()
    {
        conn = connectionClass();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT COUNT(Username) FROM AccountTable " + "WHERE Username = '"+ UserNames +"'";
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
    int checkAccount2(String user, String Pass)  {

        int count=0;
        User123 = user;
        conn = connectionClass();
        try {
            stmt = conn.createStatement();
            String sql2 = "SELECT COUNT(Username) FROM AccountTable" + " WHERE Username = '" + User123 + "'"+ " AND Password = '"+ Pass+"'";
            ResultSet rs2 = stmt.executeQuery(sql2);
            rs2.next();
            count = rs2.getInt(1);
        }
        catch (Exception e)
        {
            count = count +100000;
        }
        return (count);
    }
    Boolean checkAccountForResetPassword(String User, String Email)
    {
        int count =0;
        conn = connectionClass();
        try
        {
            stmt = conn.createStatement();
            String sql = "SELECT COUNT(Username) FROM AccountTable" + " WHERE Username = '" + User + "'"+ " AND Email = '"+ Email+"'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            count = rs.getInt(1);
            if(count==1)
            {
                return true;
            }
        }
        catch (Exception e)
        {

        }
        return false;
    }
    //Not finished quite yet
    void changePassword(String pass1, String pass2, String Email)
    {
        conn = connectionClass();
        try
        {
        stmt = conn.createStatement();
        String sql = "UPDATE AccountTable" + " SET Password = '" + pass1 + "'" + " WHERE Email = '" + Email + "'";
        stmt.executeQuery(sql);
        }
        catch (Exception e)
        {

        }
    }


}
