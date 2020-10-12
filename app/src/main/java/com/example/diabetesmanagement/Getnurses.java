package com.example.diabetesmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.diabetesmanagement.Adapters.NursesAdapter;
import com.example.diabetesmanagement.Models.NursesModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Getnurses extends AppCompatActivity {
    private static final String PATIENTS_LIST_URL = "http://192.168.1.103/dcl/getnurses.php";
    RecyclerView recyclerView;
    List<NursesModel> mData;
    NursesAdapter adapter;
    TextView error_message;
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_getnurses);

        error_message = findViewById(R.id.error_message);
        Toolbar toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

        //handle recyclerview
        recyclerView = findViewById(R.id.recyclerview);
        mData = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NursesAdapter(this, mData);
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
        loadnurses();

    }

    private void loadnurses() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PATIENTS_LIST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            Log.i("tagconvertstr","["+response+"]");
                            JSONArray nurses = new JSONArray(response);

                            for (int i = 0; i < nurses.length(); i++) {
                                JSONObject object = nurses.getJSONObject(i);
                                String id = object.getString("id");
                                String firstname = object.getString("firstname");
                                String age = object.getString("age");
                                String sex = object.getString("sex");

                                String contact = object.getString("contact");
                                String email = object.getString("email");
                                String district = object.getString("district");
                                String lastname = object.getString("lastname");
                                String hospital = object.getString("hospital");

                                NursesModel nursesModel = new NursesModel(id, firstname, age, sex, contact, email, district,hospital,lastname);
                                mData.add(nursesModel);
                                error_message.setVisibility(View.GONE);
                                //Orders_Model orders_model = new Orders_Model(food_name, food_description, food_price, id);
                                // mData.add(orders_model);
                            }

                            adapter = new NursesAdapter(Getnurses.this, mData);
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
                Toast.makeText(Getnurses.this, "could not load, please check your internet connection and try again", Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);

    }


}