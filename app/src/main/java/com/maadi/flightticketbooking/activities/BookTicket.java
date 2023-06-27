package com.maadi.flightticketbooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.maadi.flightticketbooking.MainActivity;
import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.adapters.PassengerAdapter;
import com.maadi.flightticketbooking.models.PassengerModel;
import com.maadi.flightticketbooking.models.Vehical;
import com.maadi.flightticketbooking.utilities.ECONSTANT;
import com.maadi.flightticketbooking.utilities.EHelpingFunctions;
import com.maadi.flightticketbooking.utilities.MyNetwork;
import com.manojbhadane.PaymentCardView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BookTicket extends AppCompatActivity {

    private static final String TAG = "TAG";
    EditText etBName, etBAge;
    Spinner spType;
    String PassengerType = "", gender = "", Fare, SeatType, travelDate, cardMonth, cardYear, cardNum, cardCvv;
    RadioButton radioEco, radioBusi;
    DatePicker datePicker;
    PaymentCardView creditCard;
     Vehical vehical;
     ListView ListP;
     int bookingID = 0;

     ArrayList<PassengerModel> passengerModelList ;
     PassengerAdapter passengerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket);
        ListP = findViewById(R.id.ListP);
        cardMonth= cardYear= cardNum= cardCvv = "";
        spType = (Spinner) findViewById(R.id.spType);
        Intent intent = getIntent();
        passengerModelList = new ArrayList<>();
         vehical = (Vehical) intent.getSerializableExtra("D");
        bookingID = intent.getIntExtra("BID", -1);
        Toast.makeText(this, "" + bookingID,
                Toast.LENGTH_SHORT).show();
        String[] typeArray = new String[]{
                "Trẻ em (2-12 tuổi)",
                "Trẻ em (Dưới 2 tuổi) ",
                "Người lớn (Trên 12 tuổi)"};
        ArrayAdapter<String> adapterT = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, typeArray);
        adapterT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spType.setAdapter(adapterT);
        creditCard = (PaymentCardView) findViewById(R.id.creditCard);

        datePicker = ((DatePicker) findViewById(R.id.date_picker));
        etBName = findViewById(R.id.etBName);
        etBAge = findViewById(R.id.etBAge);
        radioEco = findViewById(R.id.radioEco);
        radioBusi = (RadioButton) findViewById(R.id.radioBusi);
        ((TextView)  findViewById(R.id.tvOPrice)).setText(vehical.getEfare());
        radioEco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)  findViewById(R.id.tvOPrice)).setText(String.valueOf(passengerModelList.size() * Integer.parseInt(vehical.getEfare())));
            }
        });

        radioBusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)  findViewById(R.id.tvOPrice)).setText(String.valueOf(passengerModelList.size() * Integer.parseInt(vehical.getBfare())));

            }
        });

        findViewById(R.id.btnAddP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etBName.getText().toString().isEmpty()){
                    etBName.setError("Bạn chưa điền đủ thông tin");
                    etBName.requestFocus();
                    return;
                }
                if(etBAge.getText().toString().isEmpty()){
                    etBAge.setError("Bạn chưa điền đủ thông tin");
                    etBAge.requestFocus();
                    return;
                }
                PassengerType = spType.getSelectedItem().toString();
                if(((RadioButton)findViewById(R.id.radioMaleB)).isChecked()){
                    gender = "Nam";
                }
                else{
                    gender = "Nữ";
                }
                EHelpingFunctions.showLoading(BookTicket.this);
                addPassenger();
            }
        });

        creditCard.setOnPaymentCardEventListener(new PaymentCardView.OnPaymentCardEventListener() {
            @Override
            public void onCardDetailsSubmit(String month, String year, String cardNumber, String cvv) {
                cardMonth = month;
                cardYear = year;
                cardNum = cardNumber;
                cardCvv = cvv;

                if(radioEco.isChecked())
                {
                    Fare = vehical.getEfare();
                    SeatType = "Economy";
                }
                else{
                    Fare = vehical.getBfare();
                    SeatType = "Business";
                }
                Fare = ((TextView)findViewById(R.id.tvOPrice)).getText().toString();
                String m = String.valueOf(datePicker.getMonth());
                String d =  String.valueOf(datePicker.getDayOfMonth());
                String y =String.valueOf(datePicker.getYear());

                travelDate = y + ":" + m + ":" + d;
                if(cardNum.isEmpty() || cardYear.isEmpty() || cardMonth.isEmpty() || cardCvv.isEmpty())
                {
                    EHelpingFunctions.showError(BookTicket.this, "Error", "Bạn chưa điền đủ thông tin thẻ");
                    return;
                }
                EHelpingFunctions.showLoading(BookTicket.this);
                bookTicket();

            }

            @Override
            public void onError(String error) {
                Toast.makeText(BookTicket.this, "Error : "+error.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelClick() {

            }
        });


    }

    private void bookTicket() {
        try {
            JSONObject loginCredential = new JSONObject();
            loginCredential.put("seattype", SeatType);
            loginCredential.put("traveldate", travelDate);
            loginCredential.put("fare", Fare);
            loginCredential.put("userid", ECONSTANT.logedUser.getUser_id());
            loginCredential.put("routeid",vehical.getRid());
            loginCredential.put("cardnum",cardNum);
            loginCredential.put("year",cardYear);
            loginCredential.put("month",cardMonth);
            loginCredential.put("cvv",cardCvv);
            loginCredential.put("bid",bookingID);
            JsonObjectRequest insertRequest = new JsonObjectRequest(Request.Method.POST,
                    ECONSTANT.URL_Book_TICKET,
                    loginCredential,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            EHelpingFunctions.stopLoading();
                            Log.e(TAG, "onResponse: " + response.toString());
                            try {
                                if (response.getBoolean("data")) {

                                    new SweetAlertDialog(BookTicket.this, SweetAlertDialog.SUCCESS_TYPE)
                                            .setTitleText("Thành công")
                                            .setContentText("Vé của bạn đã được đặt!")

                                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                @Override
                                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                    sweetAlertDialog.dismissWithAnimation();
                                                    startActivity(new Intent(BookTicket.this, BookingHistory.class));
                                                    finishAffinity();
                                                }
                                            })
                                            .show();

                                } else {
                                    new SweetAlertDialog(BookTicket.this, SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("Oops...")
                                            .setContentText("Quá trình đặt vé thất bại!")
                                            .show();
                                }
                            } catch (JSONException e) {
                                new SweetAlertDialog(BookTicket.this, SweetAlertDialog.ERROR_TYPE)
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
                            new SweetAlertDialog(BookTicket.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Oops...")
                                    .setContentText("" + error.toString())
                                    .show();
                        }
                    });
            MyNetwork.getInstance(BookTicket.this).addToRequestQueue(insertRequest);

        } catch (Exception ex) {
            Log.e(TAG, "insertUserRecord: " + ex.toString());
        }
    }


    private void addPassenger() {
        try {
            JSONObject loginCredential = new JSONObject();
            loginCredential.put("name", etBName.getText().toString());
            loginCredential.put("type", PassengerType);
            loginCredential.put("gender", gender);
            loginCredential.put("age", etBAge.getText().toString());
            loginCredential.put("id", bookingID);

            JsonObjectRequest insertRequest = new JsonObjectRequest(Request.Method.POST,
                    ECONSTANT.URL_ADDP,
                    loginCredential,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            EHelpingFunctions.stopLoading();
                            Log.e(TAG, "onResponse: " + response.toString());
                            try {
                                if (response.getBoolean("data")) {
                                    PassengerModel passengerModel = new PassengerModel(etBName.getText().toString(),
                                            etBAge.getText().toString(),
                                            gender,
                                            PassengerType);
                                    passengerModelList.add(passengerModel);
                                    passengerAdapter = new PassengerAdapter(BookTicket.this, passengerModelList);
                                    ListP.setAdapter(passengerAdapter);
                                    etBName.setText("");
                                    etBAge.setText("");
                                    spType.setSelection(0);
                                    if(radioEco.isChecked())
                                    {
                                        ((TextView)  findViewById(R.id.tvOPrice)).setText(String.valueOf(passengerModelList.size() * Integer.parseInt(vehical.getEfare())));
                                    }
                                    else{
                                        ((TextView)  findViewById(R.id.tvOPrice)).setText(String.valueOf(passengerModelList.size() * Integer.parseInt(vehical.getBfare())));
                                    }

                                    new SweetAlertDialog(BookTicket.this, SweetAlertDialog.SUCCESS_TYPE)
                                            .setTitleText("Thành công!")
                                            .setContentText("Hành khách đã được thêm vào danh sách")
                                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                @Override
                                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                    sweetAlertDialog.dismissWithAnimation();
                                                }
                                            })
                                            .show();

                                } else {
                                    new SweetAlertDialog(BookTicket.this, SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("Oops...")
                                            .setContentText("Quá trình thêm hành khách đã thất bại")
                                            .show();
                                }
                            } catch (JSONException e) {
                                new SweetAlertDialog(BookTicket.this, SweetAlertDialog.ERROR_TYPE)
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
                            new SweetAlertDialog(BookTicket.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Oops...")
                                    .setContentText("" + error.toString())
                                    .show();
                        }
                    });
            MyNetwork.getInstance(BookTicket.this).addToRequestQueue(insertRequest);

        } catch (Exception ex) {
            Log.e(TAG, "insertUserRecord: " + ex.toString());
        }
    }


}