package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page2);

        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
    }
}