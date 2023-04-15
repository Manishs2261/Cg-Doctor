package com.example.manish.cgdoctors;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Hos_Location extends AppCompatActivity {

    ImageView back_hos_location;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hos_location);
        back_hos_location = findViewById(R.id.back_hos_location);

        back_hos_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Hos_Location.this,DrProfile.class));
            }
        });
    }
}