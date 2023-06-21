package com.example.se104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_new_admin1 extends AppCompatActivity {
    Button btn_back;
    Button btn_next;
    EditText pass_input;
    // mật khẩu mặc định để test
    private static final String pass = "123456";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_admin1);

         btn_back=  findViewById(R.id.button_back);
         pass_input= findViewById(R.id.editTextPassword);

         btn_next = findViewById(R.id.button_next);

         btn_back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 finish();
             }
         });


         pass_input.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 if(charSequence.length() ==0)
                 {
                     pass_input.setError("Bạn phải nhập Password ");

                 }
                 else
                     pass_input.setError(null);
             }

             @Override
             public void afterTextChanged(Editable editable) {

             }
         });

         btn_next.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View view) {
                 if(pass_input.getText().toString().compareTo(pass)== 0) {
                     Intent intent = new Intent(activity_new_admin1.this, acitivity_new_admin2.class);

                     startActivity(intent);
                 }

                 else
                     pass_input.setError("Mật khẩu đã nhập không đúng, mời nhập lại");
             }
         });



    }








}
