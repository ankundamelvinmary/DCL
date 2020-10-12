package com.example.diabetesmanagement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class nurseregistration extends AppCompatActivity {

    TextView header,patient_reg,reg_link;
    EditText firstname,lastname,age,sex,district,healthcenter,email,contact,password;
    Button register_btn;
    private static String SUBMIT_URL = "http://192.168.1.104/dcl/nursereg.php";
    private ProgressBar loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurseregistration);

        header = findViewById(R.id.header);
        patient_reg = findViewById(R.id.patient_reg);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        age = findViewById(R.id.age);
        sex = findViewById(R.id.sex);
        district = findViewById(R.id.district);
        healthcenter = findViewById(R.id.healthcenter);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        password = findViewById(R.id.password);
        register_btn = findViewById(R.id.submit);
        reg_link = findViewById(R.id.reg_link);

        reg_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(nurseregistration.this,nurselogin.class);
                startActivity(intent);
            }
        });
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sendpatientreg();
                firstname.setText("");
                lastname.setText("");
                age.setText("");
                sex.setText("");
                contact.setText("");
                email.setText("");
                district.setText("");
                healthcenter.setText("");
                password.setText("");
            }
        });


    }

    private void Sendpatientreg() {
        final ProgressDialog loading = new ProgressDialog(this);
        loading.setMessage("sending_request please wait.....");
        loading.show();
        final String firstname = this.firstname.getText().toString().trim();
        final String lastname = this.lastname.getText().toString().trim();
        final String age = this.age.getText().toString().trim();
        final String sex = this.sex.getText().toString().trim();
        final String contact = this.contact.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String district = this.district.getText().toString().trim();
        final String healthcenter = this.healthcenter.getText().toString().trim();
        final String password = this.password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, SUBMIT_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.i("tagconvertstr", "[" + response + "]");
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")) {
                                loading.dismiss();
                                Toast.makeText(getApplicationContext(), "Request sent successfully", Toast.LENGTH_SHORT).show();
                            }
                            else  if (success.equals("2")) {
                                loading.dismiss();
                                Toast.makeText(getApplicationContext(), "Either email or contact Already Exists.Check and try again!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Request not sent" + e, Toast.LENGTH_SHORT).show();
                            loading.dismiss();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Request not sent" + error, Toast.LENGTH_SHORT).show();
                        loading.dismiss();

                    }
                })

        {
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("firstname",firstname);
                params.put("lastname",lastname);
                params.put("age",age);
                params.put("sex",sex);
                params.put("contact",contact);
                params.put("email",email);
                params.put("district",district);
                params.put("hospital",healthcenter);
                params.put("password",password);
                return params;


            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}