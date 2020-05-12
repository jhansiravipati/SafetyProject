package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    private static final String channelid= "Travel Safety app";
    private static final String channelname= "Travel Safety app";
    private static final String channeldisc= "Travel Safety app notification";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel =new NotificationChannel(channelid,channelname, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channeldisc);

            NotificationManager manageroreo = getSystemService(NotificationManager.class);

            manageroreo.createNotificationChannel(channel);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification();
            }
        });

    }

    private void notification() {
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this, channelid)
                .setSmallIcon(R.drawable.mas)
                .setContentTitle("Would you like to give any review")
                .setContentText("A User is coming to your native residence. So, Would you like to give any review")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(999,builder.build());

    }
}
