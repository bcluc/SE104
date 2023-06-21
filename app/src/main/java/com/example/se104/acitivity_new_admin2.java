package com.example.se104;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

import Class_file.Admin;

public class acitivity_new_admin2 extends AppCompatActivity {

    EditText user_name;
    EditText password;
    EditText name;
    EditText Phone;
    EditText Email;
    EditText Airline_Brand;
    Button btn_back;
    Button btn_next;
    Button btn_back_2;
    Button btn_done;
    LinearLayout admin1;
    LinearLayout admin2;
    ArrayList<Admin> list_Admin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_admin2);

        user_name= findViewById(R.id.text_ID);
        password= findViewById(R.id.text_pass);
        name= findViewById(R.id.text_name);
        Phone= findViewById(R.id.text_phone);
        Email= findViewById(R.id.text_email);
        Airline_Brand= findViewById(R.id.text_Plane_ID);

        btn_back = findViewById(R.id.button_back);
        btn_next= findViewById(R.id.button_next);

        admin1= findViewById(R.id.layout_admin2);
        admin2= findViewById(R.id.layout_admin3);

        btn_back_2= findViewById(R.id.button_back_2);
        btn_done= findViewById(R.id.bttn_done);

        admin1.setVisibility(View.VISIBLE);
        admin2.setVisibility(View.GONE);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        user_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() ==0)
                {
                    user_name.setError("Bạn phải nhập ID ");

                }
                else
                    user_name.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() ==0)
                {
                    password.setError("Bạn phải nhập Password ");

                }
                else
                    password.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_name.length()==0 || password.length()==0 )
                {
                    Toast.makeText(getApplicationContext(), "Mời bạn nhập đủ thông tin", Toast.LENGTH_LONG).show();
                }else
                {
                    admin1.setVisibility(View.GONE);
                    admin2.setVisibility(View.VISIBLE);
                }

            }
        });

        btn_back_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admin1.setVisibility(View.VISIBLE);
                admin2.setVisibility(View.GONE);
            }
        });


        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() ==0)
                {
                    name.setError("Bạn phải nhập Họ và tên ");

                }
                else
                    name.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() ==0)
                {
                    Phone.setError("Bạn phải nhập Số điện thoại ");

                }
                else
                    Phone.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() ==0)
                {
                    Email.setError("Bạn phải nhập Email");

                }
                else
                    Email.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.length()==0 || Phone.length()==0 || Email.length() ==0 )
                {
                    Toast.makeText(getApplicationContext(), "Mời bạn nhập đủ thông tin", Toast.LENGTH_LONG).show();
                }

                else {

                    Toast.makeText(getApplicationContext(), "Tạo tài khoản thành công!", Toast.LENGTH_LONG).show();
                    Admin new_admin = new Admin(user_name.getText().toString(), password.getText().toString(), name.getText().toString(), Phone.getText().toString(), Email.getText().toString(), Airline_Brand.getText().toString());
                    list_Admin.add(new_admin);
                    finish();
                }

            }
        });




    }
}
