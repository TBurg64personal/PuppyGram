package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class new_account2 extends AppCompatActivity {
    private Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account2);
        nextButton = (Button) findViewById(R.id.next1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAccount();
            }
        });
    }
    public void toAccount()
    {
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }
}