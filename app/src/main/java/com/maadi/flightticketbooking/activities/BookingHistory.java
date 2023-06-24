package com.maadi.flightticketbooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.adapters.BookingAdapter;
import com.maadi.flightticketbooking.models.MyBooking;
import com.maadi.flightticketbooking.utilities.ECONSTANT;
import com.maadi.flightticketbooking.utilities.EHelpingFunctions;
import com.maadi.flightticketbooking.utilities.MyNetwork;

import org.json.JSONObject;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BookingHistory extends AppCompatActivity {
    ListView lvSearch;
    String TAG = "TAG";
    BookingAdapter bookingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_history);
        lvSearch = (ListView) findViewById(R.id.lvSearch);
        setTitle("Các vé đã đặt:");
        lvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final MyBooking model = bookingAdapter.getItem(position);
                Intent intent = new Intent(BookingHistory.this, MyBookingDetail.class);
                intent.putExtra("MES", model);
                startActivity(intent);
            }
        });
        EHelpingFunctions.showLoading(BookingHistory.this);
        myBooking();
    }

    private void myBooking() {
        try {
            JSONObject loginCredential = new JSONObject();
            loginCredential.put("userid", ECONSTANT.logedUser.getUser_id());

            JsonObjectRequest insertRequest = new JsonObjectRequest(Request.Method.POST,
                    ECONSTANT.URL_BOOKING,
                    loginCredential,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            EHelpingFunctions.stopLoading();
                            final Gson gson = new Gson();
                            Log.e(TAG, "onResponse: " + response.toString());
                            try {
                                if (response.getBoolean("status") == true) {
                                    lvSearch.setVisibility(View.VISIBLE);
                                    ((LinearLayout) findViewById(R.id.LayoutData)).setVisibility(View.GONE);

                                    MyBooking[] model1 = gson.fromJson(String.valueOf(
                                                    response.getJSONArray("data")),
                                            MyBooking[].class);
                                    bookingAdapter = new
                                            BookingAdapter(
                                            BookingHistory.this,
                                            model1);
                                    lvSearch.setAdapter(bookingAdapter);


                                } else {

                                    lvSearch.setVisibility(View.GONE);
                                    ((LinearLayout) findViewById(R.id.LayoutData)).setVisibility(View.VISIBLE);
                                }
                            } catch (Exception e) {
                                new SweetAlertDialog(BookingHistory.this, SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("Oops...")
                                        .setContentText("" + e.toString())
                                        .show();
                                Log.e(TAG, "onResponse: EXP: " + e.toString());
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e(TAG, "onErrorResponse: " + error.toString());
                            EHelpingFunctions.stopLoading();
                            new SweetAlertDialog(BookingHistory.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Oops...")
                                    .setContentText("" + error.toString())
                                    .show();
                        }
                    });
            MyNetwork.getInstance(BookingHistory.this).addToRequestQueue(insertRequest);

        } catch (Exception ex) {
            EHelpingFunctions.stopLoading();
            Log.e(TAG, "insertUserRecord: " + ex.toString());
        }

    }
}