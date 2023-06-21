package com.example.se104;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class choose_trip extends AppCompatActivity {

    Button nextButton; //Khai báo một button
    Button backButton; //Khai báo một button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_trip);

        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choose_trip.this, check_out.class);
                startActivity(intent);
            }
        });

        backButton = (Button) findViewById(R.id.out_arrow);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choose_trip.this, flight_info.class);
                startActivity(intent);
            }
        });
    }

}

