package com.Burgess.puppygram;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper2 extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "Images2";
    private static final String COL1 = "ID";
    private static final String COL2 = "Image";

    public DatabaseHelper2(@Nullable Context context) {
    super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " +TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL2 + " TEXT NOT NULL )";
        db.execSQL(createTable);

    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        String var = "DROP IF TABLE EXISTS ";
        db.execSQL(var+ TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String blob )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvals = new ContentValues();
        contentvals.put(COL2, blob);

        Log.d(TAG, "Adding Data ");
        long result= db.insert(TABLE_NAME, null, contentvals);

        if(result ==-1)
            return  false;
        else
            return true;


    }

}
