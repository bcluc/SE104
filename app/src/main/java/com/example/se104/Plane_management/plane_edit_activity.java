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

import com.example.se104.R;

import java.util.Calendar;

public class plane_edit_activity extends AppCompatActivity {
    private EditText edit_Name;
    private EditText edit_Phone;
    private EditText edit_Email;
    private TextView plane_ID;

    private Button btn_edit;

    @Override
    protected  void onCreate(Bundle savedInstanceState){

       super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_plane_edit);

       edit_Name= findViewById(R.id.text_Plane_Name_edit);
       edit_Phone= findViewById(R.id.text_Plane_Phone_edit);
       edit_Email= findViewById(R.id.text_Plane_Email_edit);

       btn_edit= findViewById(R.id.btn_edit);

       btn_edit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String Name= edit_Name.getText().toString();
               String Phone = edit_Phone.getText().toString();
               String Email= edit_Email.getText().toString();

               Intent intent=new Intent(getApplicationContext(), activity_plane_management.class);

               intent.putExtra("Name", Name);
               intent.putExtra("Phone", Phone);
               intent.putExtra("Email", Email);

               setResult(RESULT_OK, intent);
               finish();

           }
       });
    }

}
