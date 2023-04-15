package com.example.manish.cgdoctors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class My_locationn extends AppCompatActivity {

    ImageView back_my_location;

    SearchView searchView;
    ListView listView;

    ArrayList<String >arrayList;
    ArrayAdapter<String >arrayAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_locationn);

        searchView =findViewById(R.id.search_my_location);
        listView =  findViewById(R.id.list_my_view);
        back_my_location = findViewById(R.id.back_my_location);


        arrayList = new ArrayList<>();
        arrayList.add("Balod");
        arrayList.add("Baloda Bazar");
        arrayList.add("Balrampur");
        arrayList.add("Bastar");
        arrayList.add("Bemetara");
        arrayList.add("Bijapur");
        arrayList.add("Bilaspur");
        arrayList.add("Dantewada");
        arrayList.add("Dhamtari");
        arrayList.add("Durg");
        arrayList.add("Gariaband");
        arrayList.add("Gaurella-Pendra-Marwahi");
        arrayList.add("Janjgir-Champa");
        arrayList.add("Jashpur");
        arrayList.add("Kabirdham");
        arrayList.add("Kanker");
        arrayList.add("Kondagaon");
        arrayList.add("Khairagarh-Chhuikhadan-Gandai");
        arrayList.add("Korba");
        arrayList.add("Koriya");
        arrayList.add("Mahasamund");
        arrayList.add("Manendragarh-Chirmiri-Bharatpu");
        arrayList.add("Mohla-Manpur-Chowki");
        arrayList.add("Mungeli");
        arrayList.add("Narayanpur");
        arrayList.add("Raigarh");
        arrayList.add("Raipur");
        arrayList.add("Rajnandgaon");
        arrayList.add("Sarangarh-Bilaigarh");
        arrayList.add("Sakti");
        arrayList.add("Sukma");
        arrayList.add("Surajpur");
        arrayList.add("Surguja");


        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(My_locationn.this,Home.class));
            }
        });



        back_my_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(My_locationn.this,Home.class));
            }
        });

    }
}