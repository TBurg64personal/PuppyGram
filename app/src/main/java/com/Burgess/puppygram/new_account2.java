package com.Burgess.puppygram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class new_account2 extends AppCompatActivity {
    private Button nextButton;
    String Username;
    CheckBox dogbox;
    CheckBox catbox;
    CheckBox fish;
    CheckBox bird;
    CheckBox rodent;
    CheckBox Livestock;
    DatabaseHelper data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account2);
        nextButton = (Button) findViewById(R.id.next1);
        dogbox = findViewById(R.id.dogBox);
        catbox = findViewById(R.id.catBox);
        fish = findViewById(R.id.fishBox);
        bird = findViewById(R.id.birdBox);
        rodent = findViewById(R.id.rodentBox);
        Livestock = findViewById(R.id.livestockBox);
        //catbox = findViewById(R.id.catBox);
        data = new DatabaseHelper();
        Intent intent= getIntent();
        Username = intent.getExtras().getString("Username");
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAccount();
            }
        });
    }
    public void toAccount()
    {
        if(dogbox.isChecked())
        {
            data.updateAnimal(Username, "Dog");
        }
        if(catbox.isChecked())
        {
            data.updateAnimal(Username, "Cat");
        }
        if(fish.isChecked())
        {
            data.updateAnimal(Username, "fish");
        }
        if(bird.isChecked())
        {
            data.updateAnimal(Username, "bird");
        }
        if(rodent.isChecked())
        {
            data.updateAnimal(Username, "Rodent");
        }
        if(Livestock.isChecked())
        {
            data.updateAnimal(Username, "LiveStock");
        }
        callLogin();
    }
    void callLogin()
    {
        Intent intent2 = new Intent(this, ProfilePage.class);
        intent2.putExtra("Username", Username);
        startActivity(intent2);
    }
    private void toastMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}