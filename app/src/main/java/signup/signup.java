package signup;

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

import login.login;

public class signup extends AppCompatActivity {

    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        EditText ed_name = findViewById(R.id.edname);
        EditText ed_username = findViewById(R.id.edemail);
        EditText ed_phone_num = findViewById(R.id.phonenum);
        EditText ed_password = findViewById(R.id.password);
        EditText ed_confirm_pass = findViewById(R.id.confirm_pass);
        Button signup = findViewById(R.id.btn_signup);
        ImageView back = findViewById(R.id.back);
        TextView login = findViewById(R.id.login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ed_name.getText().toString();
                String email = ed_username.getText().toString();
                String phonenum = ed_phone_num.getText().toString();
                String password = ed_password.getText().toString();
                String confirm = ed_confirm_pass.getText().toString();
                if (username.length() == 0 || email.length() == 0 || phonenum.length() == 0 || password.length() == 0 || confirm.length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"Vui lòng điền đầy đủ thông tin!",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.compareTo(confirm) == 0)
                    {
                        if (isValid(password)) {
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(signup.this, smart_otp.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Password must have at least 8 characters, having letter, digit and special character",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm didn't match ", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this, login.class));
            }
        });
    }
    public static boolean isValid (String passwordhere){
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8)
            return false;
        else{
            for (int i = 0; i < passwordhere.length();i++)
            {
                if (Character.isLetter(passwordhere.charAt(i)))
                    f1 = 1;
            }
            for (int i = 0; i < passwordhere.length();i++)
            {
                if (Character.isDigit(passwordhere.charAt(i)))
                    f2 = 1;
            }
            for (int i = 0; i < passwordhere.length();i++)
            {
                char c = passwordhere.charAt(i);
                if (c>=33 && c <=46 || c==64 )
                    f3 = 1;
            }
            if(f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;
        }
    }

}
