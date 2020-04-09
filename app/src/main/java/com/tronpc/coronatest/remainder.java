package com.tronpc.coronatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class remainder extends AppCompatActivity {
    Intent intent;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    Switch sw;
    TextView switchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remainder);

        createNotificationChannel();

        sw = findViewById(R.id.sw);
        switchText = findViewById(R.id.switch_text);

        if(alarmManager!=null) {
            sw.setChecked(true);
            switchText.setText("Enabled");
        }

        else {
            sw.setChecked(false);
            switchText.setText("Disabled");
        }
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    switchText.setText("Enabled");
                    setNotification();

                }else
                {
                    switchText.setText("Disabled");
                    if(alarmManager!=null)
                    {
                        alarmManager.cancel(pendingIntent);
                    }
                }
            }
        });


    }

    private void createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            CharSequence name = "RemainderChaennel";
            String description="Channel for remainder";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("notifyme",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager= getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public void setNotification()
    {

        intent = new Intent(remainder.this,RemainderBuilder.class);
        pendingIntent= PendingIntent.getBroadcast(remainder.this,0,intent,0);

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        long req_time = 1000 * 60 *30;

        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime(),
                req_time, pendingIntent);
    }

}
