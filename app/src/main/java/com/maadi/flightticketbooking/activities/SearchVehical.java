package com.maadi.flightticketbooking.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.adapters.CityAdapter;
import com.maadi.flightticketbooking.adapters.VehicleAdapter;
import com.maadi.flightticketbooking.models.Vehical;
import com.maadi.flightticketbooking.utilities.ECONSTANT;
import com.maadi.flightticketbooking.utilities.EHelpingFunctions;
import com.maadi.flightticketbooking.utilities.MyNetwork;

import org.json.JSONObject;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SearchVehical extends AppCompatActivity {

    ListView lvSearch;
    String TAG = "TAG";
    CityAdapter fromCityAdapter, toCityAdapter;
    int fromCityID, toCityID;
    VehicleAdapter vehicleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_vehical);

        lvSearch = (ListView) findViewById(R.id.lvSearch);
        setTitle("Tìm chuyến bay");
        lvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Vehical model = vehicleAdapter.getItem(position);
                Intent intent = new Intent(SearchVehical.this, VehicleDetail.class);
                intent.putExtra("Data", model);
                startActivity(intent);
            }
        });

        findViewById(R.id.tvFromCity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fromCityAdapter = new CityAdapter(SearchVehical.this, ECONSTANT.cityList);
                AlertDialog.Builder builder = new AlertDialog.Builder(SearchVehical.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(SearchVehical.this).inflate(R.layout.city_dialog, viewGroup, false);
                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                ListView lvCity = dialogView.findViewById(R.id.ListCity);
                lvCity.setAdapter(fromCityAdapter);
                EditText etCity = dialogView.findViewById(R.id.etCity);
                ImageView ivClose = dialogView.findViewById(R.id.ivClose);
                ivClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                etCity.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        fromCityAdapter.getFilter().filter(s.toString());
                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count,
                                                  int after) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });
                lvCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        fromCityAdapter.getItem(i).getCityname();
                        fromCityID = fromCityAdapter.getItem(i).getCityid();
                        //Toast.makeText(SearchDonor.this, ""+cityID, Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                        ((TextView) findViewById(R.id.tvFromCity)).setText(fromCityAdapter.getItem(i).getCityname());
                    }
                });
                alertDialog.show();
            }
        });


        findViewById(R.id.tvToCity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toCityAdapter = new CityAdapter(SearchVehical.this, ECONSTANT.cityList);
                AlertDialog.Builder builder = new AlertDialog.Builder(SearchVehical.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(SearchVehical.this).inflate(R.layout.city_dialog, viewGroup, false);
                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                ListView lvCity = dialogView.findViewById(R.id.ListCity);
                lvCity.setAdapter(toCityAdapter);
                EditText etCity = dialogView.findViewById(R.id.etCity);
                ImageView ivClose = dialogView.findViewById(R.id.ivClose);
                ivClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                etCity.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        toCityAdapter.getFilter().filter(s.toString());
                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count,
                                                  int after) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });
                lvCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        toCityAdapter.getItem(i).getCityname();
                        toCityID = toCityAdapter.getItem(i).getCityid();
                        //Toast.makeText(SearchDonor.this, ""+cityID, Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                        ((TextView) findViewById(R.id.tvToCity)).setText(toCityAdapter.getItem(i).getCityname());
                    }
                });
                alertDialog.show();
            }
        });

        findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView) findViewById(R.id.tvNote)).setVisibility(View.GONE);
                EHelpingFunctions.showLoading(SearchVehical.this);
                searchVehicle();
            }
        });
    }

    private void searchVehicle() {
        try {
            JSONObject loginCredential = new JSONObject();
            loginCredential.put("fromcity", fromCityID);
            loginCredential.put("tocity", toCityID);

            JsonObjectRequest insertRequest = new JsonObjectRequest(Request.Method.POST,
                    ECONSTANT.URL_SEARCH_VEHICLE,
                    loginCredential,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            EHelpingFunctions.stopLoading();
                            final Gson gson = new Gson();
                            Log.e(TAG, "onResponse: " + response.toString());
                            try {
                                if (response.getBoolean("status") == true) {
                                    ((TextView) findViewById(R.id.tvTitlee)).setVisibility(View.VISIBLE);
                                    lvSearch.setVisibility(View.VISIBLE);
                                    ((LinearLayout) findViewById(R.id.LayoutData)).setVisibility(View.GONE);

                                    Vehical[] model1 = gson.fromJson(String.valueOf(
                                                    response.getJSONArray("data")),
                                            Vehical[].class);
                                    vehicleAdapter = new
                                            VehicleAdapter(
                                            SearchVehical.this,
                                            model1);
                                    lvSearch.setAdapter(vehicleAdapter);


                                } else {
                                    ((TextView) findViewById(R.id.tvTitlee)).setVisibility(View.GONE);

                                    lvSearch.setVisibility(View.GONE);
                                    ((LinearLayout) findViewById(R.id.LayoutData)).setVisibility(View.VISIBLE);
                                }
                            } catch (Exception e) {
                                new SweetAlertDialog(SearchVehical.this, SweetAlertDialog.ERROR_TYPE)
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
                            new SweetAlertDialog(SearchVehical.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Oops...")
                                    .setContentText("" + error.toString())
                                    .show();
                        }
                    });
            MyNetwork.getInstance(SearchVehical.this).addToRequestQueue(insertRequest);

        } catch (Exception ex) {
            EHelpingFunctions.stopLoading();
            Log.e(TAG, "insertUserRecord: " + ex.toString());
        }

    }
}