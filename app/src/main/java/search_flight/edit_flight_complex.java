package search_flight;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

public class edit_flight_complex extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_flight_complex);
        Button btn_continue = findViewById(R.id.complete_edit);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_information();
            }
        });
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void check_information() {
        EditText flight_id = findViewById(R.id.flight_id);
        EditText et_number_of_business_chair = findViewById(R.id.number_of_business_chair);
        EditText et_number_of_special_popular_chair = findViewById(R.id.number_of_special_popular_char);
        EditText et_number_of_popular_chair = findViewById(R.id.number_of_popular_chair);
        EditText et_number_of_first_chair = findViewById(R.id.number_of_first_chair);
        EditText et_cost_of_business_chair = findViewById(R.id.cost_of_business_chair);
        EditText et_cost_of_special_popular_chair = findViewById(R.id.cost_of_special_popular_char);
        EditText et_cost_of_popular_chair = findViewById(R.id.cost_of_popular_char);
        EditText et_cost_of_first_chair = findViewById(R.id.cost_of_first_chair);

        if (    flight_id.getText().toString().length() != 0
                && et_number_of_business_chair.getText().toString().length() != 0
                && et_number_of_special_popular_chair.getText().toString().length() != 0
                && et_number_of_popular_chair.getText().toString().length() != 0
                && et_number_of_first_chair.getText().toString().length() != 0
                && et_cost_of_business_chair.getText().toString().length() != 0
                && et_cost_of_special_popular_chair.getText().toString().length() != 0
                && et_cost_of_popular_chair.getText().toString().length() != 0
                && et_cost_of_first_chair.getText().toString().length() != 0)
        {
            Toast.makeText(getApplicationContext(), "Thêm chuyến bay thành công!", Toast.LENGTH_SHORT).show();
//            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
        }
    }

}
