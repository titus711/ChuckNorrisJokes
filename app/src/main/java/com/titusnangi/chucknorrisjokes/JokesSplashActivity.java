package com.titusnangi.chucknorrisjokes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class JokesSplashActivity extends AppCompatActivity {

    public final int SPLASH_DISPLAY_LENGTH = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_splash);

        new Handler().postDelayed(new Runnable() {

            // Using handler with postDelayed calling runnable run method

            @Override
            public void run() {
                Intent myIntent = new Intent(JokesSplashActivity.this, MainActivity.class);
                startActivity(myIntent);
                finish();
            }


        }, SPLASH_DISPLAY_LENGTH);

    }
}