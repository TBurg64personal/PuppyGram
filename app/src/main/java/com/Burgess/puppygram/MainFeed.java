package com.Burgess.puppygram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;

public class MainFeed extends AppCompatActivity {
    private Button findAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_feed);
        findAccount= findViewById(R.id.findAccount);
        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(new com.Burgess.puppygram.ImageFeedAdapter(this));
        findAccount.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                startActivity(new Intent(MainFeed.this, FindAccount.class));
        }
        });

        Button btn1 = (Button)findViewById(R.id.newPic);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainFeed.this, NewPicture.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.profileButton);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainFeed.this, ProfilePage.class));
            }
        });
    }
}