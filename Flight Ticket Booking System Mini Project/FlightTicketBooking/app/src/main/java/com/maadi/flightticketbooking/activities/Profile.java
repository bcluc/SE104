package com.maadi.flightticketbooking.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.utilities.ECONSTANT;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        CircleImageView imgProfile = findViewById(R.id.imgProfile);
        Glide.with(this).load(
                        ECONSTANT.URL_IMG_USER + ECONSTANT.logedUser.getUser_image())
                .into(imgProfile);

        ((TextView)findViewById(R.id.tvPName)).setText(ECONSTANT.logedUser.getUser_name());
        ((TextView)findViewById(R.id.tvPDate)).setText(ECONSTANT.logedUser.getUser_email());
        ((TextView)findViewById(R.id.tvPBlood)).setText(ECONSTANT.logedUser.getAddress());
        ((TextView)findViewById(R.id.tvPCity)).setText(ECONSTANT.logedUser.getCityname());
        ((TextView)findViewById(R.id.tvPPhone)).setText(ECONSTANT.logedUser.getUser_mobile());

    }
}