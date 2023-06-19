package forget_pass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.se104.R;

import forget_pass.create_pass.create_pass;
import login.login;
import signup.signup;

public class otp_forget_pass extends AppCompatActivity {

    EditText inputcode1,inputcode2,inputcode3,inputcode4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_forget_password);
        inputcode1 = findViewById(R.id.otp_box1);
        inputcode2 = findViewById(R.id.otp_box2);
        inputcode3 = findViewById(R.id.otp_box3);
        inputcode4 = findViewById(R.id.otp_box4);

        setupOTPInputs();
        Button btn_continue = findViewById(R.id.btn_continue);
        ImageView back = findViewById(R.id.back);
        TextView signup = findViewById(R.id.signup);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(otp_forget_pass.this, create_pass.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(otp_forget_pass.this, signup.class));

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