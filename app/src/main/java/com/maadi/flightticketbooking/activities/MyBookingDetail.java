package com.maadi.flightticketbooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.adapters.PassengerAdapter;
import com.maadi.flightticketbooking.models.MyBooking;
import com.maadi.flightticketbooking.models.PassengerModel;
import com.maadi.flightticketbooking.utilities.ECONSTANT;
import com.maadi.flightticketbooking.utilities.EHelpingFunctions;
import com.maadi.flightticketbooking.utilities.MyNetwork;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MyBookingDetail extends AppCompatActivity {
    private static final String TAG = "TAG";
    MyBooking data;
    ListView ListPe;
    PassengerAdapter passengerAdapter;
    ArrayList<PassengerModel> listPessenger = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking_detail);

        Intent intent = getIntent();
         data = (MyBooking) intent.getSerializableExtra("MES");
        ListPe = findViewById(R.id.ListPe);
//        ((TextView) findViewById(R.id.tvname)).setText(data.getName());
        ((TextView) findViewById(R.id.bgrp)).setText(data.getFromcity());
        ((TextView) findViewById(R.id.phone)).setText(data.getTocity());
        ((TextView) findViewById(R.id.city)).setText(data.getTraveldate());
        ((TextView) findViewById(R.id.detail)).setText(data.getVclass() + " Class");
        ((TextView) findViewById(R.id.fare)).setText(data.getFare());
//        ((TextView) findViewById(R.id.bfate)).setText(data.getGender());
//        ((TextView) findViewById(R.id.duration)).setText(data.getType());
//        ((TextView) findViewById(R.id.cardnumbers)).setText(data.getCardnum().toString());
//        ((TextView) findViewById(R.id.cardyear)).setText(data.getYear());
//        ((TextView) findViewById(R.id.cardm)).setText(data.getMonth());
//        ((TextView) findViewById(R.id.cardcvv)).setText(data.getCvv());

        EHelpingFunctions.showLoading(MyBookingDetail.this);
        passenger();
    }

    private void passenger() {
        try {
            JSONObject loginCredential = new JSONObject();
            loginCredential.put("bid", data.getId());

            JsonObjectRequest insertRequest = new JsonObjectRequest(Request.Method.POST,
                    ECONSTANT.URL_GETPAS,
                    loginCredential,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            EHelpingFunctions.stopLoading();
                            final Gson gson = new Gson();
                            Log.e(TAG, "onResponse: " + response.toString());

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e(TAG, "onErrorResponse: " + error.toString());

                        }
                    });
            MyNetwork.getInstance(MyBookingDetail.this).addToRequestQueue(insertRequest);

        } catch (Exception ex) {
            EHelpingFunctions.stopLoading();
            Log.e(TAG, "insertUserRecord: " + ex.toString());
        }

    }
}