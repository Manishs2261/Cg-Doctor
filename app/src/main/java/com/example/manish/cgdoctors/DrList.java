package com.example.manish.cgdoctors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.manish.cgdoctors.Adapter.ClickLineserDrList;
import com.example.manish.cgdoctors.Adapter.DrListadapter;

public class DrList extends AppCompatActivity implements ClickLineserDrList {

    ImageView back_Dr_list;


    int [] dr_img = {R.drawable.doc,R.drawable.doc,R.drawable.doc,R.drawable.doc,R.drawable.doc};
    String [] dr_name = {"Dr. Manish sahu","Dr. Manish sahu","Dr. Manish sahu","Dr. Manish sahu","Dr. Manish sahu"};
    String [] hos_name ={"Janta Hospital","Janta Hospital","Janta Hospital","Janta Hospital","Janta Hospital"};
    String [] rating_num = {"3.4","3.4","3.4","3.4","3.4"};
    String [] rating_ple = {"120","120","120","120","120"};
    String [] hos_add ={"Bilaspur","Bilaspur","Bilaspur","Bilaspur","Bilaspur"};
    String [] dr_fee = {"500","500","500","500","500"};
    String [] avi_mornig = {"Morning 10:00AM - 12:00PM","Morning 10:00AM - 12:00PM","Morning 10:00AM - 12:00PM","Morning 10:00AM - 12:00PM","Morning 10:00AM - 12:00PM"};
    String [] avi_eving = {"Evining 06:00PM - 08:00PM","Evining 06:00PM - 08:00PM","Evining 06:00PM - 08:00PM","Evining 06:00PM - 08:00PM","Evining 06:00PM - 08:00PM"};

    RecyclerView recyleview_Drlist;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_list);


        recyleview_Drlist = findViewById(R.id.recyleview_Drlist);
        back_Dr_list = findViewById(R.id.back_hos_location);



        DrListadapter drListadapter = new DrListadapter(dr_img,dr_name,hos_name,rating_num,rating_ple,hos_add,dr_fee,avi_mornig,avi_eving,this);

        recyleview_Drlist.setLayoutManager(new LinearLayoutManager(this));
        recyleview_Drlist.setAdapter(drListadapter);


        back_Dr_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DrList.this,Home.class));
            }
        });


    }




    @Override
    public void itmeOnClick(int position)
    {
        startActivity(new Intent(DrList.this,DrProfile.class));

    }

    @Override
    public void buttonOnClick(int positionn) {

         startActivity(new Intent(DrList.this,BookAppoiment.class));
        
    }

    @Override
    public void buttonOnCall(int positioon) {


        Toast.makeText(this, "Call now ", Toast.LENGTH_SHORT).show();
    }


}