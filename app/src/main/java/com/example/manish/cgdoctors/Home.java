package com.example.manish.cgdoctors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manish.cgdoctors.Adapter.Home_re_adapter;
import com.example.manish.cgdoctors.Adapter.ClickLineserRecyl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Home extends AppCompatActivity implements ClickLineserRecyl , LocationListener {

SearchView searchView;

LocationManager locationManager = null;


    Home_re_adapter home_re_adapter;
    RecyclerView recyclerView;
    TextView current_location;
    ImageView person_manu,notification,my_location;

    List<ModalClassHome> modalClassHomes = new ArrayList<>();
    List<ModalClassHome> arrList;







    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyleview_home);
        person_manu = findViewById(R.id.person_manu);
        notification = findViewById(R.id.notification);
        my_location = findViewById(R.id.my_location);
        current_location = findViewById(R.id.current_location);
        searchView = findViewById(R.id.searchview);








         recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Home.this,2);
        recyclerView.setLayoutManager(gridLayoutManager);


        //=================================recylerView ========================================

        modalClassHomes.add(new ModalClassHome(R.drawable.geranal,"सभी बीमारी","General P."));
        modalClassHomes.add(new ModalClassHome(R.drawable.nose,"नाक","Nose S."));
        modalClassHomes.add(new ModalClassHome(R.drawable.dentists,"दाँतों ","Dentist"));
        modalClassHomes.add(new ModalClassHome(R.drawable.chest,"सीना","Chest S."));
        modalClassHomes.add(new ModalClassHome(R.drawable.child,"बच्चों","childe"));
        modalClassHomes.add(new ModalClassHome(R.drawable.bone,"हड्डी","Bone"));
        modalClassHomes.add(new ModalClassHome(R.drawable.ear,"कान","Ear S."));
        modalClassHomes.add(new ModalClassHome(R.drawable.neurologist,"Neurologist","Neurologist"));
        modalClassHomes.add(new ModalClassHome(R.drawable.cardiology,"हृदय","cardiology"));
        modalClassHomes.add(new ModalClassHome(R.drawable.oncology,"कैंसर", "Tumour"));
        modalClassHomes.add(new ModalClassHome(R.drawable.eyes,"आँखें","Eyes"));
        modalClassHomes.add(new ModalClassHome(R.drawable.diabetologist,"मधुमेह","Suger"));
        modalClassHomes.add(new ModalClassHome(R.drawable.gastroenterologist,"पाचन","Gastroenterology"));
        modalClassHomes.add(new ModalClassHome(R.drawable.homeopathy,"Homeopathy","Homeopathy"));
        modalClassHomes.add(new ModalClassHome(R.drawable.piles,"बवासीर","Piles"));
        modalClassHomes.add(new ModalClassHome(R.drawable.urologist,"मूत्र","Urologist"));
        modalClassHomes.add(new ModalClassHome(R.drawable.physiotherapy,"Physiotherapy","Physiotherapy"));
        modalClassHomes.add(new ModalClassHome(R.drawable.skin,"त्वचा","Skin"));
        modalClassHomes.add(new ModalClassHome(R.drawable.plastic,"Plastic S.","Plastic S."));
        modalClassHomes.add(new ModalClassHome(R.drawable.veterinary,"जानवर","Animal"));


         home_re_adapter = new Home_re_adapter(Home.this,modalClassHomes, Home.this);
        recyclerView.setAdapter(home_re_adapter);



        //========================Manu bar button==================================
        person_manu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this, MainManu.class));


            }
        });



        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Notification.class));

            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                arrList = new ArrayList<>();
                if(query.length()>0)
                {
                    for(int i = 0; i< modalClassHomes.size(); i++)
                    {
                         if(modalClassHomes.get(i).getName_e().toUpperCase().contains(query.toUpperCase()))
                         {
                             ModalClassHome modal = new ModalClassHome();
                             modal.setName_e(modalClassHomes.get(i).getName_e());
                             modal.setName_h(modalClassHomes.get(i).getName_h());
                             modal.setDis_img(modalClassHomes.get(i).getDis_img());
                             arrList.add(modal);
                         }

                    }
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(Home.this,2);
                    recyclerView.setLayoutManager(gridLayoutManager);

                    home_re_adapter = new Home_re_adapter(Home.this,arrList, Home.this);
                    recyclerView.setAdapter(home_re_adapter);

                }
                else
                {
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(Home.this,2);
                    recyclerView.setLayoutManager(gridLayoutManager);

                    home_re_adapter = new Home_re_adapter(Home.this,modalClassHomes, Home.this);
                    recyclerView.setAdapter(home_re_adapter);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrList = new ArrayList<>();
                if(newText.length()>0)
                {
                    for(int i = 0; i< modalClassHomes.size(); i++)
                    {
                        if(modalClassHomes.get(i).getName_e().toUpperCase().contains(newText.toUpperCase()))
                        {
                            ModalClassHome modal = new ModalClassHome();
                            modal.setName_e(modalClassHomes.get(i).getName_e());
                            modal.setName_h(modalClassHomes.get(i).getName_h());
                            modal.setDis_img(modalClassHomes.get(i).getDis_img());
                            arrList.add(modal);
                        }

                    }
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(Home.this,2);
                    recyclerView.setLayoutManager(gridLayoutManager);

                    home_re_adapter = new Home_re_adapter(Home.this,arrList, Home.this);
                    recyclerView.setAdapter(home_re_adapter);

                }
                else
                {
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(Home.this,2);
                    recyclerView.setLayoutManager(gridLayoutManager);

                    home_re_adapter = new Home_re_adapter(Home.this,modalClassHomes, Home.this);
                    recyclerView.setAdapter(home_re_adapter);
                }
                return false;
            }
        });




        // Run time permission ========================


        if(ContextCompat.checkSelfPermission(Home.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {ActivityCompat.requestPermissions(Home.this,new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION
           },100);

       }


        getLocation();


        my_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this,My_locationn.class));


            }
        });





    }
//================================================================






    private boolean isGPSEnable()
    {
        boolean isEnable = false;
        if(locationManager == null)
        {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        }
        isEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        return isEnable;

    }


//========================================================================

    @Override
    public void onItemClicked(int position) {

        Intent intent = new Intent(Home.this,DrList.class);

        startActivity(intent);

    }


//==================================================================


    public void onBackPressed() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Close..");
        alertDialog.setMessage("Do you want to close this application ..?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finishAffinity();

            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDialog.show();

    }




    //=================================================

    @SuppressLint("MissingPermission")
    private void getLocation() {

        //Toast.makeText(this, "location", Toast.LENGTH_SHORT).show();

        try {

            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,5000,5,Home.this);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    //=========================================


    @Override
    public void onLocationChanged(@NonNull Location location) {

       // Toast.makeText(this, ""+location.getLatitude()+","+location.getLongitude(), Toast.LENGTH_SHORT).show();

        try {
            Geocoder geocoder = new Geocoder(Home.this,Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);



            String cityname= addresses.get(0).getLocality();
               current_location.setText(cityname);




        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        LocationListener.super.onStatusChanged(provider, status, extras);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }





}