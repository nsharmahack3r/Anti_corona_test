package com.tronpc.coronatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Animation rotationAnimation;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.corona_img);
        rotationAnimation();
    }

    private void rotationAnimation() {
        rotationAnimation= AnimationUtils.loadAnimation(this,R.anim.rotate_animation);
        imageView.startAnimation(rotationAnimation);
    }
    public void coronaTest(View view)
    {

        Intent i = new Intent(MainActivity.this,test.class);
        startActivity(i);
    }

    public void symptoms(View view)
    {
        Intent i = new Intent(MainActivity.this,symptoms.class);
        startActivity(i);
    }

    public void remainder(View view)
    {
        Intent i = new Intent(MainActivity.this,remainder.class);
        startActivity(i);
    }
    public void statistics(View view)
    {
        Intent i = new Intent(MainActivity.this,statistics.class);
        startActivity(i);
    }

    public void precautions(View view)
    {
        Intent i = new Intent(MainActivity.this,precautions.class);
        startActivity(i);
    }

}
