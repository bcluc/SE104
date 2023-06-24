package com.maadi.flightticketbooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.models.Vehical;
import com.maadi.flightticketbooking.utilities.ECONSTANT;
import com.maadi.flightticketbooking.utilities.EHelpingFunctions;
import com.maadi.flightticketbooking.utilities.MyNetwork;

import org.json.JSONArray;
import org.json.JSONObject;

public class VehicleDetail extends AppCompatActivity {

    private static final String TAG = "TAG";
    int id = 0;
    Vehical vehical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);
        Intent intent = getIntent();
        vehical = (Vehical) intent.getSerializableExtra("Data");

        ((TextView) findViewById(R.id.tvname)).setText(vehical.getVehicle_name());
        ((TextView) findViewById(R.id.bgrp)).setText(vehical.getFromcity());
        ((TextView) findViewById(R.id.phone)).setText(vehical.getTocity());
        ((TextView) findViewById(R.id.city)).setText(vehical.getDeptime());
        ((TextView) findViewById(R.id.detail)).setText(vehical.getArivaltime());
        ((TextView) findViewById(R.id.date)).setText(vehical.getEfare() + " VND");
        ((TextView) findViewById(R.id.bfate)).setText(vehical.getBfare()+ " VND");
        ((TextView) findViewById(R.id.duration)).setText(vehical.getDuration());

        findViewById(R.id.btncc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EHelpingFunctions.showLoading(VehicleDetail.this);
                getBookingID();

            }
        });
    }
    void getBookingID()
    {
        try {
            JSONObject loginCredential = new JSONObject();
            loginCredential.put("userid", ECONSTANT.logedUser.getUser_id());
            loginCredential.put("routeid",vehical.getRid());

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                    ECONSTANT.URL_GET_BID,
                    loginCredential,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            EHelpingFunctions.stopLoading();
                            Log.e(TAG, "onResponse: " + response);
                            final Gson gson = new Gson();
                            try {

                                JSONArray z = response.getJSONArray("data");
                                 Object j = z.getJSONObject(0).getString("bid");
                                 int x = Integer.parseInt(j.toString());
                                Intent  intent1  = new Intent(VehicleDetail.this,BookTicket.class);
                                intent1.putExtra("D", vehical);
                                intent1.putExtra("BID", x);
                                startActivity(intent1);



                            } catch (Exception e) {
                                Log.e(TAG, "onResponse: " + e.toString());
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    EHelpingFunctions.stopLoading();

                    Log.e(TAG, "onErrorResponse: " + error.toString());
                }
            });
            MyNetwork.getInstance(this).addToRequestQueue(jsonObjectRequest);
        } catch (Exception e) {
            Log.e(TAG, "getBanner: " + e.toString());
        }

    }
}