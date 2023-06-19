package forget_pass.create_pass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.se104.R;

import login.login;
import signup.signup;

public class complete_create_pass extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_success);
        Button btn_login = findViewById(R.id.btn_login);
        ImageView back = findViewById(R.id.back);
        TextView signup = findViewById(R.id.signup);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(complete_create_pass.this, login.class);
                startActivity(intent);
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
                Intent intent = new Intent(complete_create_pass.this, signup.class);
                startActivity(intent);
            }
        });
    }
}