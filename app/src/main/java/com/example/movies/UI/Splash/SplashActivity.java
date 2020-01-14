package com.example.movies.UI.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import com.example.movies.R;
import com.example.movies.UI.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 1200;
    public ImageView spashImage;
    Animation animFadeIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        spashImage =findViewById(R.id.splash);

        //Animation
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);
        animFadeIn.setRepeatCount(4);

        spashImage.startAnimation(animFadeIn);
        new Handler().postDelayed(
                this::gotoMain,
                SPLASH_TIME_OUT);
    }

    private void gotoMain(){
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

}