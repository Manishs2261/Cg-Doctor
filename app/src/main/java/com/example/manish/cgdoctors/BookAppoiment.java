package com.example.manish.cgdoctors;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;

public class BookAppoiment extends AppCompatActivity {

    ImageView back_book;
    TextView book_date,book_button;

    DatePickerDialog datePickerDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appoiment);


        book_date = findViewById(R.id.book_date);
        back_book = findViewById(R.id.back_hos_location);
        book_button = findViewById(R.id.book_button);

        back_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(BookAppoiment.this, DrList.class));
            }
        });

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        book_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datePickerDialog = new DatePickerDialog(BookAppoiment.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        book_date.setText(dayOfMonth+"/"+(month + 1)+"/"+year);

                    }
                },year,month,day);

                datePickerDialog.show();
            }
        });

       book_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Toast.makeText(BookAppoiment.this, "Book Successfully ", Toast.LENGTH_SHORT).show();
               startActivity(new Intent(BookAppoiment.this,DrList.class));
           }
       });
        
    }
}