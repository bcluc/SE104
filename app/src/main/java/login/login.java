package login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

import forget_pass.forget_pass;
import signup.signup;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login1);
        EditText edusr_name = findViewById(R.id.username);
        EditText edpassword = findViewById(R.id.password);
        Button btn_login = findViewById(R.id.btn_login);
        TextView signup = findViewById(R.id.signup);
        TextView forget_pass = findViewById(R.id.forget_pass);
        ImageView back = findViewById(R.id.back);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edusr_name.getText().toString();
                String password = edpassword.getText().toString();
                if (userName.length() == 0 || password.length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"Vui lòng điền ầy đủ thông tin!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });
        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, forget_pass.class);
                startActivity(intent);
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