package com.maadi.flightticketbooking.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.models.Developer;


public class AboutUs extends AppCompatActivity {

    private Developer origin = new Developer();
    private Button btn_video;
    private Button btn_pay;
    private Button btn_call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        btn_video = (Button) findViewById(R.id.btn_video_demo);
        btn_pay = (Button) findViewById(R.id.btn_video_pay);
        btn_call = (Button) findViewById(R.id.btn_call);

        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = origin.getUrl_demo();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = origin.getUrl_pay();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(origin.getPhone_number()));
                startActivity(callIntent);
            }
        });

    }
}