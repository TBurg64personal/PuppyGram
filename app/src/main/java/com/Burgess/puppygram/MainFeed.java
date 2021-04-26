package com.Burgess.puppygram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainFeed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_feed);

        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(new com.Burgess.puppygram.ImageFeedAdapter(this));

    }
}