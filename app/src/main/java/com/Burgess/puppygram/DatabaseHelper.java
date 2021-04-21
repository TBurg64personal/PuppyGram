package com.Burgess.puppygram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;
import android.widget.TableRow;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "Accounts";
    private static final String COL1 = "ID";
    private static final String COL2 = "FirstName";
    private static final String COL3 = "LastName";
    private static final String COL4 = "Email";
    private static final String COL5 = "Password";
    private static final String COL6 = "UserName";

    public DatabaseHelper(@Nullable Context context) {
    super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " +TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL2 + " TEXT NOT NULL, " + COL3 + " TEXT NOT NULL, "+COL4+" TEXT NOT NULL, "+COL5+" TEXT NOT NULL, "+COL6+" TEXT NOT NULL )";
        db.execSQL(createTable);

    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        String var = "DROP IF TABLE EXISTS ";
        db.execSQL(var+ TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String firstName, String lastName, String Email, String Password, String UserName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvals = new ContentValues();
        contentvals.put(COL2, firstName);
        contentvals.put(COL3,lastName);
        contentvals.put(COL4,Email);
        contentvals.put(COL5,Password);
        contentvals.put(COL6,UserName);

        Log.d(TAG, "Adding Data ");
        long result= db.insert(TABLE_NAME, null, contentvals);

        if(result ==-1)
            return  false;
        else
            return true;


    }
    public int selectResult(String Username, String Password)
    {
        //SQLiteDatabase db = this.getReadableDatabase();
        //String count = String.format("SELECT * FROM Accounts WHERE %s = %s AND %s = %s", COL6,Username, COL5, Password);
       // Cursor courser = db.rawQuery(count,new String[] { String.valueOf(Username) });
        //int val = courser.getInt(0);
        return 1;





    }

}
