package com.maadi.flightticketbooking.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.appizona.yehiahd.fastsave.FastSave;
import com.google.gson.Gson;
import com.maadi.flightticketbooking.MainActivity;
import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.adapters.CityAdapter;
import com.maadi.flightticketbooking.models.User;
import com.maadi.flightticketbooking.utilities.ECONSTANT;
import com.maadi.flightticketbooking.utilities.EHelpingFunctions;
import com.maadi.flightticketbooking.utilities.MyNetwork;
import com.mikelau.croperino.Croperino;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;

public class Register extends AppCompatActivity {

    public CircleImageView ivUser;
    public EditText etName, etEmail, etpassword, etphone, etSAddress;
    public TextView tvSCity;
    private String email, password,name,address,phone;
    private CityAdapter cityAdapter;
    int type, cityID;
    private static final String TAG = ECONSTANT.TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ivUser = findViewById(R.id.ivUser);
        etName = findViewById(R.id.etSName);
        etEmail = findViewById(R.id.etSEmail);
        etpassword = findViewById(R.id.etSPassword);
        etphone = findViewById(R.id.etSPhone);
        etSAddress = findViewById(R.id.etSAddress);
        tvSCity = findViewById(R.id.tvSCity);

        cityAdapter = new CityAdapter(Register.this,  ECONSTANT.cityList);

        findViewById(R.id.ibUserImagePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(Register.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Select Image")
                        .setConfirmButton("Gallery", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismissWithAnimation();
                                Croperino.prepareGallery(Register.this);
                            }
                        })

                        .show();
            }
        });

             findViewById(R.id.tvSCity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(Register.this).inflate(R.layout.city_dialog, viewGroup, false);
                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                ListView lvCity = dialogView.findViewById(R.id.ListCity);
                lvCity.setAdapter(cityAdapter);
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
                        cityAdapter.getFilter().filter(s.toString());
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
                        cityAdapter.getItem(i).getCityname();
                        cityID = cityAdapter.getItem(i).getCityid();
                        //Toast.makeText(Register.this, ""+cityAdapter.getItem(i).getCityName(), Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                        ((TextView)findViewById(R.id.tvSCity)).setText( cityAdapter.getItem(i).getCityname());
                    }
                });
                alertDialog.show();
            }
        });
        findViewById(R.id.btnSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    name = etName.getText().toString().trim();
                    email = etEmail.getText().toString().trim();
                    password = etpassword.getText().toString().trim();
                    phone = etphone.getText().toString().trim();
                    address = etSAddress.getText().toString();

                    if (name.isEmpty()) {
                        etName.setError("Điền đầy đủ thông tin");
                        etName.requestFocus();
                        return;
                    }
                    if (email.isEmpty()) {
                        etEmail.setError("Điền đầy đủ thông tin");
                        etEmail.requestFocus();
                        return;
                    }
                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        etEmail.setError("Email không hợp lệ");
                        etEmail.requestFocus();
                        return;
                    }
                    if (password.isEmpty()) {
                        etpassword.setError("Điền đầy đủ thông tin");
                        etpassword.requestFocus();
                        return;
                    }
                    if (password.length() < 6) {
                        etpassword.setError("Mật khẩu ít nhất 6 kí tự");
                        etpassword.requestFocus();
                        return;
                    }
                    if (phone.isEmpty()) {
                        etphone.setError("Điền đầy đủ thông tin");
                        etphone.requestFocus();
                        return;
                    }
                    if (address.isEmpty()) {
                        etSAddress.setError("Điền đầy đủ thông tin");
                        etSAddress.requestFocus();
                        return;
                    }

                    if(tvSCity.equals("Chọn thành phố"))
                    {
                        EHelpingFunctions.showError(Register.this,"Error", "Cần chọn thành phố");
                    }
                    EHelpingFunctions.showLoading(Register.this);
                    new MyTask().execute();
                } catch (Exception ex) {
                    Log.e(TAG, "onClick: " + ex.toString());
                }
            }
        });
    }

    private Uri saveImage(Bitmap bm, Register mainActivity) {
        File imagesF = new File(mainActivity.getCacheDir(), "images");
        Uri uri = null;
        try{
            imagesF.mkdir();
            File file = new File(imagesF, "cap_img.png");
            FileOutputStream stream = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 100, stream);
            stream.flush();
            stream.close();
            uri = FileProvider.getUriForFile(mainActivity.getApplicationContext(), "com.maadi.blooddonation" + ".provider", file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return uri;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == -1 && requestCode == 101)
        {
            String result = data.getStringExtra("RESULT");
            Uri resultUri = null;
            if(result!= null )
            {
                resultUri = Uri.parse(result);
            }
            else{
                resultUri = Uri.parse("android.resource://com.maadi.flightticketbooking/drawable/ava_sample");
            }
            ivUser.setImageURI(resultUri);
            final InputStream imageStream;
            try {
                imageStream = getContentResolver().openInputStream(resultUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    private class MyTask extends AsyncTask<Void, Void, String> {
        SweetAlertDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.e(TAG, "onPreExecute: ");
        }

        @Override
        protected String doInBackground(Void... uri) {
            try {
                Bitmap selectedImage = ((BitmapDrawable) ivUser.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                selectedImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] b = baos.toByteArray();
                String base64EncodingString = Base64.encodeToString(b, Base64.DEFAULT);
                return base64EncodingString;
            } catch (Exception ex) {
                Log.e(TAG, "doInBackground: " + ex.toString());
                return null;
            }

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result != null) {
                Log.e(TAG, "onPostExecute: " + result);
                User user = new User(1, cityID,
                        etName.getText().toString(),
                        etEmail.getText().toString(),
                        etpassword.getText().toString(),
                        etphone.getText().toString(),
                        result, "",
                        etSAddress.getText().toString());
                insertUserRecord(user);
            }
        }
    }

    private void insertUserRecord(User user) {
        try {
            JsonObjectRequest insertRequest = new JsonObjectRequest(Request.Method.POST,
                    ECONSTANT.URL_SIGNUP,
                    new JSONObject(new Gson().toJson(user)),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            EHelpingFunctions.stopLoading();
                            Log.e(TAG, "onResponse: " + response.toString());
                            try {
                                if (response.getBoolean("data") == true) {

                                    new SweetAlertDialog(Register.this, SweetAlertDialog.SUCCESS_TYPE)
                                            .setTitleText("Sign Up Successfully!")
                                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                @Override
                                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                    sweetAlertDialog.dismissWithAnimation();
                                                    validation(email, password, type);
                                                }
                                            })
                                            .show();


                                } else {
                                    new SweetAlertDialog(Register.this, SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("Oops...")
                                            .setContentText("Email already exist Or not available!")
                                            .show();
                                }
                            } catch (JSONException e) {
                                new SweetAlertDialog(Register.this, SweetAlertDialog.ERROR_TYPE)
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
                            new SweetAlertDialog(Register.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Oops...")
                                    .setContentText("" + error.toString())
                                    .show();


                        }
                    });
            MyNetwork.getInstance(Register.this).addToRequestQueue(insertRequest);

        } catch (Exception ex) {
            Log.e(TAG, "insertUserRecord: " + ex.toString());
        }

    }

    private void validation(String email, String password, int type) {
        try {
            JSONObject loginCredential = new JSONObject();
            loginCredential.put("email", email);
            loginCredential.put("password", password);
            final JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST,
                    ECONSTANT.URL_LOGIN,
                    loginCredential,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (response.getBoolean("status")) {
                                    Gson gson = new Gson();
                                    EHelpingFunctions.stopLoading();
                                    ECONSTANT.logedUser = gson.fromJson(response.getJSONObject("data").toString(),
                                            User.class);
                                    Log.e(TAG, "onResponse: " + response.toString());
                                    FastSave.getInstance().saveObject(ECONSTANT.KEY_LOGED_USER, ECONSTANT.logedUser);
                                    // EHelpingFunctions.stopLoading();
                                    startActivity(
                                            new Intent(Register.this,
                                                    MainActivity.class));
                                    Register.this.finish();


                                } else {
                                    EHelpingFunctions.stopLoading();
                                    new SweetAlertDialog(Register.this, SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("Oops...")
                                            .setContentText("Please Check your Email and password!")
                                            .show();
                                }
                            } catch (Exception ex) {
                                EHelpingFunctions.stopLoading();
                                Log.e(TAG, "onResponse: " + ex.toString());
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            EHelpingFunctions.stopLoading();
                            Log.e(TAG, "onErrorResponse: ERROR: " + error.toString());
                        }
                    }
            );
            MyNetwork.getInstance(Register.this).addToRequestQueue(objectRequest);
        } catch (Exception ex) {
            EHelpingFunctions.stopLoading();
            Log.e(TAG, "validation: " + ex.toString());
        }
    }
}