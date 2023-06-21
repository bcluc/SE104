package com.example.se104;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class choose_trip extends AppCompatActivity {

    Button nextButton; //Khai báo một button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_trip);

        nextButton = (Button) findViewById(R.id.next_button); //Ánh xạ button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(choose_trip.this, check_out.class));
            }
        });
    }

}

