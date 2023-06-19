package forget_pass.create_pass;

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

public class create_pass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_pass);
        Button btn_continue = findViewById(R.id.btn_continue);
        EditText ed_password = findViewById(R.id.password);
        EditText ed_confirm_pass = findViewById(R.id.confirm_pass);
        ImageView back = findViewById(R.id.back);
        TextView signup = findViewById(R.id.signup);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed_confirm_pass.getText().toString().compareTo(ed_password.getText().toString()) == 0){
                Intent intent = new Intent(create_pass.this,complete_create_pass.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(),"Mật khẩu xác nhận không đúng!",Toast.LENGTH_SHORT).show();
            }
        }});
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(create_pass.this,signup.class);
                startActivity(intent);
            }
        });
    }
}