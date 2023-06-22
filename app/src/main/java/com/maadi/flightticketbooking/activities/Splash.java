package com.maadi.flightticketbooking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.Welcome;
import com.maadi.flightticketbooking.models.City;
import com.maadi.flightticketbooking.utilities.ECONSTANT;
import com.maadi.flightticketbooking.utilities.MyNetwork;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Splash extends AppCompatActivity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        validateSplash();

    }

    void validateSplash()
    {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                ECONSTANT.URL_GET_CITY,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            ECONSTANT.cityList = new ArrayList<>();
                            JSONArray s = response.getJSONArray("City");
                            for (int i = 0; i < s.length(); i++) {
                                City c = new City();
                                c.setCityid(Integer.parseInt(s.getJSONObject(i).getString("cityid")));
                                c.setCityname(s.getJSONObject(i).getString("cityname"));
                                ECONSTANT.cityList.add(c);
                            }
                            Thread thread1 = new Thread()
                            {
                                public void run()
                                {
                                    try {
                                        sleep(6000);
                                    } catch (InterruptedException e) {
                                        Log.e(TAG, "run: "+e.toString());
                                    }
                                    startActivity(new Intent(Splash.this, Welcome.class));
                                    finish();
                                }
                            };
                            thread1.start();
                        } catch (Exception ex) {
                            //  EHelpingFunctions.stopLoading();
                            Log.e(TAG, "onResponse: " + ex.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //  EHelpingFunctions.stopLoading();
                        Log.e(TAG, "onErrorResponse: ERROR: " + error.toString());
                    }
                });
        MyNetwork.getInstance(Splash.this).addToRequestQueue(request);


    }
}