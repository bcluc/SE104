package com.example.se104;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class fragment_home extends Fragment implements DatePickerDialog.OnDateSetListener {

    private object_user user;
    private object_developer developer = new object_developer();
    private ArrayList<object_Airline_Brand> arrayList_airline_brand;
    private adapter_Airline_Brand adapter_airline_brand;
    private navigation_bottom bottom_navigation;
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
    Button btn_cskh_vid;
    Button btn_cskh_pay;
    Button btn_cskh_call;
    Button btn_cskh_chat;
    Button btn_find_flight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        //find View by ID
        bottom_navigation = (navigation_bottom) getActivity();
        lay_day_go = (LinearLayout) view.findViewById(R.id.lay_day_go);
        lay_day_back = (LinearLayout) view.findViewById(R.id.lay_day_back);

        tv_day_go = view.findViewById(R.id.txt_day_go);
        tv_day_back = view.findViewById(R.id.txt_day_back);
        tv_quanity_customer = view.findViewById(R.id.txt_customer_quanity);

        rb_one_way = view.findViewById(R.id.rb_one_way);
        rb_two_way = view.findViewById(R.id.rb_two_way);

        spiner_des_start = view.findViewById(R.id.spinner_des_start);
        spiner_des_end = view.findViewById(R.id.spinner_des_end);

        btn_switch_des = view.findViewById(R.id.btn_switch_des);
        btn_plus_customer = view.findViewById(R.id.btn_plus_customer);
        btn_minus_customer = view.findViewById(R.id.btn_minus_customer);
        btn_cskh_vid = view.findViewById(R.id.btn_cskh_vid);
        btn_cskh_pay = view.findViewById(R.id.btn_cskh_pay);
        btn_cskh_call = view.findViewById(R.id.btn_cskh_hotline);
        btn_cskh_chat = view.findViewById(R.id.btn_cskh_chat);
        btn_find_flight = view.findViewById(R.id.btn_find_flight);

        // adapter
        initList();
        adapter_airline_brand = new adapter_Airline_Brand(getContext(),arrayList_airline_brand);
        spiner_des_start.setAdapter(adapter_airline_brand);
        spiner_des_end.setAdapter(adapter_airline_brand);

        // setOnCLick
        btn_find_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottom_navigation.goto_find_flights_activity();
            }
        });
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
        btn_cskh_vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(developer.getLink_yt_intro()); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btn_cskh_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(developer.getHotline()));
                startActivity(intent);
            }
        });
        btn_cskh_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(developer.getLink_yt_pay()); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btn_cskh_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottom_navigation.goto_message_activity();
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
                bottom_navigation.choose_day_go_activity(tv_day_go);
            }
        });

        lay_day_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottom_navigation.choose_day_go_activity(tv_day_back);
            }
        });
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }
}