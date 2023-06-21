package com.example.se104;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class payment_method extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);
    }

    public void onClick(View view) {
        startActivity(new Intent(payment_method.this, flight_info.class));
    }

}


