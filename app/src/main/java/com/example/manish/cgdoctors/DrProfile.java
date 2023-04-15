package com.example.manish.cgdoctors;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class DrProfile extends AppCompatActivity {

    RatingBar ratingBar2;

    ImageView back_Dr_pro,call_now_pro,share_pro,hos_location;
    TextView book_appoi_pro,rating_now_pro,help_pro,report_pro;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_profile);

        back_Dr_pro = findViewById(R.id.back_hos_location);
        book_appoi_pro = findViewById(R.id.book_appoi_pro);
        call_now_pro = findViewById(R.id.call_now_pro);
        share_pro = findViewById(R.id.share_pro);
        hos_location =  findViewById(R.id.hos_location);
        rating_now_pro = findViewById(R.id.rating_now_pro);
        help_pro = findViewById(R.id.help_pro);
        report_pro = findViewById(R.id.report_pro);
        ratingBar2 = (RatingBar) findViewById(R.id.ratingBar2);

        back_Dr_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DrProfile.this,DrList.class));
            }
        });


        book_appoi_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DrProfile.this,BookAppoiment.class));
            }
        });



        call_now_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DrProfile.this, CallNow.class));
            }
        });

        share_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrProfile.this,Share_pro.class));
            }
        });

        hos_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DrProfile.this,Hos_Location.class));
            }
        });

        rating_now_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float f = ratingBar2.getRating();
                Toast.makeText(DrProfile.this, "Rating "+f, Toast.LENGTH_SHORT).show();


            }
        });

        help_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrProfile.this,Helpp.class));
            }
        });

        report_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrProfile.this,ReportNow.class));
            }
        });
    }
}