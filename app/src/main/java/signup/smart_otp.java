package signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

import login.login;

public class smart_otp extends AppCompatActivity {

    Button btn_continue;
    ImageView btn_back;
    EditText inputcode1,inputcode2,inputcode3,inputcode4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_vertical_phone_number);
        inputcode1 = findViewById(R.id.otp_box1);
        inputcode2 = findViewById(R.id.otp_box2);
        inputcode3 = findViewById(R.id.otp_box3);
        inputcode4 = findViewById(R.id.otp_box4);
        setupOTPInputs();
        btn_continue = findViewById(R.id.btn_continue);
        btn_back = findViewById(R.id.back);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(smart_otp.this, success_create.class));
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void setupOTPInputs()
    {
        inputcode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()){
                    inputcode2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        inputcode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()){
                    inputcode3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        inputcode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()){
                    inputcode4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }

}
