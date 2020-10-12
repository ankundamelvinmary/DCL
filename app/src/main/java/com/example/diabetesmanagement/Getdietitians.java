package com.example.diabetesmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.diabetesmanagement.Adapters.DietitiansAdapter;
import com.example.diabetesmanagement.Models.DietitiansModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Getdietitians extends AppCompatActivity {
    private static final String DIETITIANS_LIST_URL = "http://192.168.1.103/dcl/getpharmacies.php";
    RecyclerView recyclerView;
    List<DietitiansModel> mData;
    DietitiansAdapter adapter;
    TextView error_message;
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdietitians);

        error_message = findViewById(R.id.error_message);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        //handle recyclerview
        recyclerView = findViewById(R.id.recyclerview);
        mData = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DietitiansAdapter(this, mData);
        recyclerView.setAdapter(adapter);
        //bottom navigation part
        navigation = findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);


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
        loaddietitians();

    }

    private void loaddietitians() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, DIETITIANS_LIST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            Log.i("tagconvertstr","["+response+"]");
                            JSONArray dietitians = new JSONArray(response);
                            for (int i = 0; i < dietitians.length(); i++) {
                                JSONObject object = dietitians.getJSONObject(i);
                                String id = object.getString("id");
                                String fullnames = object.getString("fullnames");
                                String contact = object.getString("contact");
                                String email = object.getString("email");
                                String location = object.getString("location");

                                DietitiansModel dietitiansModel = new DietitiansModel(id,fullnames,email,contact,location);
                                mData.add(dietitiansModel);
                                error_message.setVisibility(View.GONE);
                                //Orders_Model orders_model = new Orders_Model(food_name, food_description, food_price, id);
                                // mData.add(orders_model);
                            }

                            adapter = new DietitiansAdapter(Getdietitians.this, mData);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            error_message.setVisibility(View.VISIBLE);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error_message.setVisibility(View.VISIBLE);
                error_message.setVisibility(View.VISIBLE);
                Toast.makeText(Getdietitians.this, "could not load, please check your internet connection and try again", Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}