package com.example.diabetesmanagement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class nurselogin extends AppCompatActivity {
    TextView header,login_header,register_link;
    EditText contact, password;
    Button login_btn;
    private static String URL_NURSELOGIN = "http://192.168.1.104/dcl/nurselogin.php";
    SessionManager sessionManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurselogin);

        sessionManager = new SessionManager(this);
        header = findViewById(R.id.header);
        login_header = findViewById(R.id.login_header);
        register_link = findViewById(R.id.register_link);
        contact = findViewById(R.id.contact);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_btn = new Intent(getApplicationContext(),NurseHome.class);
                startActivity(login_btn);
            }
        });

        register_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), nurseregistration.class);
                startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = contact.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if (!user.isEmpty() || !pass.isEmpty()){
                    Login(user,pass);
                }
                else {
                    contact.setError("Enter a valid phonenumber");
                    password.setError("Enter password");
                }
            }
        });

    }

    private void Login(final String phone, final String pass){

        final ProgressDialog loading = new ProgressDialog(nurselogin.this);
        loading.setMessage("Loging in please wait....");
        loading.show();
        login_btn.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_NURSELOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    Log.i("tagconvertstr","["+response+"]");
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");
                    if (success.equals("1")) {
                        Toast.makeText(nurselogin.this, "Login successful", Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id").trim();
                            String firstname = object.getString("firstname").trim();
                            String contact = object.getString("contact").trim();

                            sessionManager.createSession(firstname,contact);
                            Intent intent = new Intent(nurselogin.this, NurseHome.class);
                            intent.putExtra("firstname",firstname);


//                            Intent intent = new Intent(nurselogin.this, NurseHome.class);
//                            intent.putExtra("firstname",firstname);

                            startActivity(intent);
                            loading.dismiss();
                            login_btn.setVisibility(View.VISIBLE);

                        }
                    } else if (success.equals("0")) {
                        loading.dismiss();
                        login_btn.setVisibility(View.VISIBLE);
                        Toast.makeText(nurselogin.this, "Login error no account found", Toast.LENGTH_SHORT).show();


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    loading.dismiss();
                    login_btn.setVisibility(View.VISIBLE);
                    Toast.makeText(nurselogin.this, "Login error "+e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismiss();
                        login_btn.setVisibility(View.VISIBLE);
                        Toast.makeText(nurselogin.this, "Login error "+ error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                })
        {
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("contact",phone);
                params.put("password",pass);
                return params;


            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
}