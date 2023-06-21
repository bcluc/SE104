package com.example.se104.Plane_management;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.se104.R;

import java.util.Calendar;

public class plane_add_activity extends AppCompatActivity {
    private EditText save_ID;
    private EditText save_Name;
    private EditText save_Phone;
    private EditText save_Email;

    private Button btn_Save;

    @Override
    protected void onCreate( Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_plane_add));

        save_ID= findViewById(R.id.text_Plane_ID_input);
        save_Name= findViewById(R.id.text_Plane_Name_input);
        save_Phone= findViewById(R.id.text_Plane_Phone_input);
        save_Email= findViewById(R.id.text_Plane_Email_input);

        btn_Save= findViewById(R.id.bttn_done);

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID= save_ID.getText().toString();
                String Name = save_Name.getText().toString();
                String Phone = save_Phone.getText().toString();
                String Email = save_Email.getText().toString();

                Intent intent=new Intent(getApplicationContext(), activity_plane_management.class);

                intent.putExtra("Name",Name);
                intent.putExtra("ID", ID);
                intent.putExtra("Phone Number", Phone);
                intent.putExtra("Email", Email);

                startActivity(intent);
                finish();
            }
        });
    }

    }
