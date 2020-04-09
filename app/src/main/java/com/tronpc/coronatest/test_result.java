package com.tronpc.coronatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class test_result extends AppCompatActivity {
    TextView res_value,res_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);

        Intent intent = getIntent();
        int y =intent.getIntExtra("current_marks",3);
        String x=String.valueOf(intent.getIntExtra("current_marks",3));
        String a;

        if(y<=21)
            a=getResources().getString(R.string.res_safe);
        else if(y>21&&y<36)
            a=getResources().getString(R.string.res_mild);
        else
            a=getResources().getString(R.string.res_strong);

        res_value=findViewById(R.id.res_value);
        res_card=findViewById(R.id.res_card);
        res_value.setText(x+"%");
        res_card.setText(String.format("%s %s%%. %s", a, x, getResources().getString(R.string.res_main)));
    }
}
