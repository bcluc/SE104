package com.maadi.flightticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.appizona.yehiahd.fastsave.FastSave;
import com.maadi.flightticketbooking.activities.Login;
import com.maadi.flightticketbooking.activities.Register;
import com.maadi.flightticketbooking.models.User;
import com.maadi.flightticketbooking.utilities.ECONSTANT;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ECONSTANT.logedUser = FastSave.getInstance().getObject(ECONSTANT.KEY_LOGED_USER, User.class);
        if (ECONSTANT.logedUser != null) {
            startActivity(new Intent(Welcome.this, MainActivity.class));
            finish();
        }

        findViewById(R.id.btnLog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Welcome.this, Login.class));
                finish();
            }
        });
        findViewById(R.id.btnRegis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Welcome.this, Register.class));
                finish();
            }
        });
    }
}