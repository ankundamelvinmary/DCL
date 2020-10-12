package com.example.diabetesmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class nurseprofile extends AppCompatActivity {
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurseprofile);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit = new Intent(getApplicationContext(),nursesettings.class);
                startActivity(submit);
            }
        });

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.ic_home:
                        Intent home = new Intent(getApplicationContext(),Flash.class);
                        startActivity(home);
                        break;

                    case R.id.ic_help:
                        Intent help = new Intent(getApplicationContext(),Help.class);
                        startActivity(help);
                        break;

                    case R.id.ic_list:
                        Intent list = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(list);
                        break;

                    case R.id.ic_settings:
                        Intent settings = new Intent(getApplicationContext(),nursesettings.class);
                        startActivity(settings);
                        break;

                    case R.id.ic_logout:
                        Intent logout = new Intent(getApplicationContext(),nurselogin.class);
                        startActivity(logout);
                        break;
                }



                return false;
            }
        });
    }
}