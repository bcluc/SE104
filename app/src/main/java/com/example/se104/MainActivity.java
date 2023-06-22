package com.example.se104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import login.login;

public class MainActivity extends AppCompatActivity {
    Button btn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.intro);
        Button btn_start;
        btn_start = findViewById(R.id.Button);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(new Intent(MainActivity.this, login.class));
            }
        });
=======
        setContentView(R.layout.addfight);
>>>>>>> hung-admin-branch
    }
}