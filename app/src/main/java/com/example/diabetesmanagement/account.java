package com.example.diabetesmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class account extends AppCompatActivity {
    ImageView back;
    CardView privacy,security,editdata,deleteaccount,changepass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(getApplicationContext(),nursesettings.class);
                startActivity(back);
            }
        });
        privacy = findViewById(R.id.privacy);
        security = findViewById(R.id.security);
        editdata = findViewById(R.id.editdata);
        editdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editdata = new Intent(getApplicationContext(),profile.class);
                startActivity(editdata);
            }
        });
        deleteaccount = findViewById(R.id.deleteaccount);
        changepass = findViewById(R.id.changepass);
        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changepass = new Intent(getApplicationContext(),changepassword.class);
                startActivity(changepass);
            }
        });
    }
}