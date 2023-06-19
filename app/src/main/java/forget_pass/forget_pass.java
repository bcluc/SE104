package forget_pass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.se104.R;

import signup.signup;

public class forget_pass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_pass);
        EditText ed_email = findViewById(R.id.username);
        TextView signup = findViewById(R.id.signup);
        Button btn_continue = findViewById(R.id.btn_continue);
        ImageView back = findViewById(R.id.back);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(forget_pass.this, signup.class);
                startActivity(intent);
            }
        });
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed_email.getText().toString().length()!=0) {
                    Intent intent = new Intent(forget_pass.this, otp_forget_pass.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập đầy đủ email!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}