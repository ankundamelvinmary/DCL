package com.example.diabetesmanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Flash extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    ImageView logo;
    Animation sideAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_flash);

        logo= findViewById(R.id.logo);

        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side);

        logo.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Flash.this,NurseHome .class);
                Flash.this.startActivity(intent);
                Flash.this.finish();




            }
        },SPLASH_DISPLAY_LENGTH);
    }
}