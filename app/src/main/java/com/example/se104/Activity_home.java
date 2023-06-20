package com.example.se104;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Activity_home extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private object_user user;
    private ArrayList<object_Airline_Brand> arrayList_airline_brand;
    private adapter_Airline_Brand adapter_airline_brand;
    TextView tv_day_go;
    TextView tv_day_back;
    TextView tv_quanity_customer;
    int ck_day = 0;
    RadioButton rb_one_way;
    RadioButton rb_two_way;
    LinearLayout lay_day_go;
    LinearLayout lay_day_back;
    Spinner spiner_des_start;
    Spinner spiner_des_end;
    Button btn_switch_des;
    Button btn_plus_customer;
    Button btn_minus_customer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //find View by ID
            lay_day_go = (LinearLayout) findViewById(R.id.lay_day_go);
            lay_day_back = (LinearLayout) findViewById(R.id.lay_day_back);

            tv_day_go = findViewById(R.id.txt_day_go);
            tv_day_back = findViewById(R.id.txt_day_back);
            tv_quanity_customer = findViewById(R.id.txt_customer_quanity);

            rb_one_way = findViewById(R.id.rb_one_way);
            rb_two_way = findViewById(R.id.rb_two_way);

            spiner_des_start = findViewById(R.id.spinner_des_start);
            spiner_des_end = findViewById(R.id.spinner_des_end);

            btn_switch_des = findViewById(R.id.btn_switch_des);
            btn_plus_customer = findViewById(R.id.btn_plus_customer);
            btn_minus_customer = findViewById(R.id.btn_minus_customer);

        // adapter
            initList();
            adapter_airline_brand = new adapter_Airline_Brand(this,arrayList_airline_brand);
            spiner_des_start.setAdapter(adapter_airline_brand);
            spiner_des_end.setAdapter(adapter_airline_brand);

        // setOnCLick
            btn_switch_des.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos_des_start = spiner_des_start.getSelectedItemPosition();
                    int pos_des_end = spiner_des_end.getSelectedItemPosition();
                    spiner_des_start.setSelection(pos_des_end);
                    spiner_des_end.setSelection(pos_des_start);
                }
            });
            btn_plus_customer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int number = Integer.parseInt(tv_quanity_customer.getText().toString());
                    number ++;
                    String quanity = Integer.toString(number);
                    tv_quanity_customer.setText(quanity);
                }
            });
            btn_minus_customer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int number = Integer.parseInt(tv_quanity_customer.getText().toString());
                    if(number > 0) number --;
                    String quanity = Integer.toString(number);
                    tv_quanity_customer.setText(quanity);
                }
            });
            rb_one_way.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lay_day_back.setVisibility(View.GONE);
                }
            });

            rb_two_way.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lay_day_back.setVisibility(View.VISIBLE);
                }
            });

            lay_day_go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ck_day = 1;
                    DialogFragment datePicker = new DatePickerFragment();
                    datePicker.show(getSupportFragmentManager(), "Date Picker");
                }
            });

            lay_day_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ck_day = 2;
                    DialogFragment datePicker = new DatePickerFragment();
                    datePicker.show(getSupportFragmentManager(), "Date Picker");
                }
            });





    }

    private void initList()
    {
        arrayList_airline_brand = new ArrayList<>();
        arrayList_airline_brand.add(new object_Airline_Brand("------","", "-","-"));
        arrayList_airline_brand.add(new object_Airline_Brand("SG","Sài Gòn", "000","123"));
        arrayList_airline_brand.add(new object_Airline_Brand("HN","Hà Nội", "000","123"));
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        String currentDateString = DateFormat.getDateInstance(DateFormat.DEFAULT).format(c.getTime());
        if(ck_day == 2) {
            tv_day_back.setText(currentDateString);
            ck_day = 0;
        }
        else if(ck_day == 1) {
            tv_day_go.setText(currentDateString);
            ck_day = 0;
        }

    }
}