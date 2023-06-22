package com.maadi.flightticketbooking.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.utilities.ECONSTANT;
import com.maadi.flightticketbooking.utilities.EHelpingFunctions;
import com.maadi.flightticketbooking.utilities.MyNetwork;

import org.json.JSONException;
import org.json.JSONObject;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ContactUs extends AppCompatActivity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((EditText)findViewById(R.id.etcontactus)).getText().toString().isEmpty()){
                    ((EditText)findViewById(R.id.etcontactus)).setError("Must Fill Field");
                    return;
                }
                EHelpingFunctions.showLoading(ContactUs.this);
                insertRecord();
            }
        });
    }

    private void insertRecord() {
        try {
            JSONObject loginCredential = new JSONObject();
            loginCredential.put("text", ((EditText)findViewById(R.id.etcontactus)).getText().toString());
            loginCredential.put("id", ECONSTANT.logedUser.getUser_id());
            JsonObjectRequest insertRequest = new JsonObjectRequest(Request.Method.POST,
                    ECONSTANT.URL_Contact_US,
                    loginCredential,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            EHelpingFunctions.stopLoading();
                            Log.e(TAG, "onResponse: " + response.toString());
                            try {
                                if (response.getBoolean("data") == true) {

                                    new SweetAlertDialog(ContactUs.this, SweetAlertDialog.SUCCESS_TYPE)
                                            .setTitleText("Added Successfully!")
                                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                @Override
                                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                    sweetAlertDialog.dismissWithAnimation();
                                                    finish();
                                                }
                                            })
                                            .show();


                                } else {
                                    new SweetAlertDialog(ContactUs.this, SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("Oops...")
                                            .setContentText("Error Occur!")
                                            .show();
                                }
                            } catch (JSONException e) {
                                new SweetAlertDialog(ContactUs.this, SweetAlertDialog.ERROR_TYPE)
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
                            new SweetAlertDialog(ContactUs.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Oops...")
                                    .setContentText("" + error.toString())
                                    .show();


                        }
                    });
            MyNetwork.getInstance(ContactUs.this).addToRequestQueue(insertRequest);

        } catch (Exception ex) {
            Log.e(TAG, "insertUserRecord: " + ex.toString());
        }

    }
}