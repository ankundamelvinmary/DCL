package com.example.diabetesmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.AuthFailureError;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class NurseHome extends AppCompatActivity {

    LinearLayout ll;
    TextView header;
    CardView doctorlink,patient,followup,dietitian,appointments,ddd,pharmacy,physiothelapy;
    SessionManager sessionManager;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_flash);
        setContentView(R.layout.activity_nursehome);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        HashMap<String, String> user = sessionManager.getUserDetail();
        String names = user.get(SessionManager.NAME);
         name  = user.get(SessionManager.NAME);

        header = findViewById(R.id.header);
        header.setText(names);

//

        ll = findViewById(R.id.ll);

//        Intent intent = getIntent();
//        String firstname = intent.getStringExtra("firstname");
//        header.setText("Welcome home " +firstname);

        doctorlink = findViewById(R.id.doctorlink);
        doctorlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent doctorlink = new Intent(getApplicationContext(),Nurselink.class);
                startActivity(doctorlink);
            }
        });
        patient = findViewById(R.id.patient);
        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent patient = new Intent(getApplicationContext(),Getpatients.class);
                startActivity(patient);
            }
        });
        followup = findViewById(R.id.followup);
        followup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent followup = new Intent(getApplicationContext(),Followup.class);
                startActivity(followup);
            }
        });
        dietitian = findViewById(R.id.dietitian);
        dietitian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dietitian = new Intent(getApplicationContext(),Getdietitians.class);
                startActivity(dietitian);
            }
        });
        appointments= findViewById(R.id.appointments);
        appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appointments = new Intent(getApplicationContext(),Appointments.class);
                startActivity(appointments);
            }
        });
        ddd = findViewById(R.id.ddd);
        ddd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ddd = new Intent(getApplicationContext(),Criticalpatients.class);
                startActivity(ddd);
            }
        });
        pharmacy = findViewById(R.id.pharmacy);
        pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pharmacy = new Intent(getApplicationContext(),Getpharmacies.class);
                startActivity(pharmacy);
            }
        });
        physiothelapy = findViewById(R.id.physiothelapy);
        physiothelapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent physiothelapy = new Intent(getApplicationContext(),Getphysiothelapist.class);
                startActivity(physiothelapy);
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

    protected Map<String,String> getParams()throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put("name",name);
        return params;
    }

}