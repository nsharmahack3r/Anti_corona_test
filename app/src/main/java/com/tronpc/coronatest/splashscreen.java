package com.tronpc.coronatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class splashscreen extends AppCompatActivity {

    Animation stAnimation;

    ImageView imageView;
    static final int SPLASH_TIME=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

     imageView = findViewById(R.id.coronavirus_img);
     straightAnimation();
     questionStarter();
    }

    private void straightAnimation() {
        stAnimation= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        imageView.startAnimation(stAnimation);
    }


    private void questionStarter() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(splashscreen.this,MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME);}
}
