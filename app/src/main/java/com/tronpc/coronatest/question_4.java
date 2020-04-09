package com.tronpc.coronatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class question_4 extends AppCompatActivity {

    Button option1, option2, option3, next;
    private int marks=0;
    int finalm=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_4);

        option1 = findViewById(R.id.op1);
        option2 = findViewById(R.id.op2);
        option3 = findViewById(R.id.op3);
        next = findViewById(R.id.next_4);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1Selected();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op2Selected();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op3Selected();
            }
        });

        Intent intent = getIntent();
        finalm+=intent.getIntExtra("current_marks",3);
    }

    private void op1Selected() {
        option1.setBackgroundResource(R.drawable.ques_4_selected);
        option1.setTextColor(getResources().getColor(R.color.white));

        option2.setBackgroundResource(R.drawable.question_4_button);
        option2.setTextColor(getResources().getColor(R.color.ques_4));

        option3.setBackgroundResource(R.drawable.question_4_button);
        option3.setTextColor(getResources().getColor(R.color.ques_4));

        marks=3;
        linker();

    }

    private void op2Selected() {
        option2.setBackgroundResource(R.drawable.ques_4_selected);
        option2.setTextColor(getResources().getColor(R.color.white));

        option1.setBackgroundResource(R.drawable.question_4_button);
        option1.setTextColor(getResources().getColor(R.color.ques_4));

        option3.setBackgroundResource(R.drawable.question_4_button);
        option3.setTextColor(getResources().getColor(R.color.ques_4));
        marks=5;
        linker();

    }

    private void op3Selected() {
        option3.setBackgroundResource(R.drawable.ques_4_selected);
        option3.setTextColor(getResources().getColor(R.color.white));

        option2.setBackgroundResource(R.drawable.question_4_button);
        option2.setTextColor(getResources().getColor(R.color.ques_4));

        option1.setBackgroundResource(R.drawable.question_4_button);
        option1.setTextColor(getResources().getColor(R.color.ques_4));
        marks=10;
        linker();

    }

    private void linker() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(question_4.this, question_5.class);
                finalm+=marks;
                intent.putExtra("current_marks",finalm);
                startActivity(intent);
                finish();
            }
        });
    }

}
