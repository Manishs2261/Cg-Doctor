package com.example.manish.cgdoctors;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainManu extends AppCompatActivity {

    ImageView user_edit,cut_manu;

    TextView        logout_user,register_userl,my_appointment,my_transaction,dr_register,dr_login,dr_logout,setting,help,term,app_feedback;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_manu);

        register_userl = findViewById(R.id.register_user);
        my_appointment = findViewById(R.id.my_appointment);
        my_transaction = findViewById(R.id.my_transaction);
        dr_login = findViewById(R.id.dr_login);
        dr_logout = findViewById(R.id.dr_logout);
        dr_register = findViewById(R.id.dr_register);
        setting = findViewById(R.id.setting);
        help = findViewById(R.id.help);
        app_feedback = findViewById(R.id.app_feedback);
        term = findViewById(R.id.term);
        user_edit = findViewById(R.id.user_edit);
        cut_manu = findViewById(R.id.cut_manu);
        logout_user = findViewById(R.id.logout_user);


        logout_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainManu.this,LogoutUser.class));
            }
        });


//        dr_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(MainManu.this,));
//            }
//        });

        cut_manu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainManu.this, Home.class));
            }
        });






        user_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainManu.this,EditUser.class));
            }
        });






        register_userl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(MainManu.this,RegisterUser.class));


            }
        });


        my_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainManu.this,MyAppoitment.class));


            }
        });


        my_transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainManu.this,MyTransition.class));
            }
        });


        dr_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainManu.this,RegisterDr.class));
            }
        });


        dr_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainManu.this,LoginDr.class));
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainManu.this,SettingS.class));
            }
        });

      help.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              startActivity(new Intent(MainManu.this,Helpp.class));
          }
      });

      app_feedback.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {


              startActivity(new Intent(MainManu.this,Helpp.class));
          }
      });



      term.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {


              startActivity(new Intent(MainManu.this,TermAndCondition.class));
          }
      });

    }
}