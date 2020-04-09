package com.tronpc.coronatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class test extends AppCompatActivity {

    Animation rotationAnimation;
    ImageView imageView;
    Button letsGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        imageView = findViewById(R.id.test_img);
        rotationAnimation();

    }
    private void rotationAnimation() {
        rotationAnimation= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        imageView.startAnimation(rotationAnimation);
    }

    public void question1(View view)
    {
        Intent intent = new Intent(test.this,question_1.class);
        startActivity(intent);
    }
}
