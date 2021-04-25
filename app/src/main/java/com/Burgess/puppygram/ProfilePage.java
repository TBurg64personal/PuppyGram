package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page2);

        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        Button btn = (Button)findViewById(R.id.newPic);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfilePage.this, NewPicture.class));
            }
        });
    }
}