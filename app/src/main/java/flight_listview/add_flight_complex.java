package flight_listview;

import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

public class add_flight_complex extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_flight_conplex);
        Button btn_continue = findViewById(R.id.complete_add);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_information();
            }
        });
    }

    private void check_information() {
        EditText et_number_of_business_chair = findViewById(R.id.number_of_business_chair);
        EditText et_number_of_special_popular_chair = findViewById(R.id.number_of_special_popular_char);
        EditText et_number_of_popular_chair = findViewById(R.id.number_of_popular_chair);
        EditText et_number_of_first_chair = findViewById(R.id.number_of_first_chair);
        EditText et_cost_of_business_chair = findViewById(R.id.cost_of_business_chair);
        EditText et_cost_of_special_popular_chair = findViewById(R.id.cost_of_special_popular_char);
        EditText et_cost_of_popular_chair = findViewById(R.id.cost_of_popular_char);
        EditText et_cost_of_first_chair = findViewById(R.id.cost_of_first_chair);

        if (et_number_of_business_chair.getText() != null
        && et_number_of_special_popular_chair.getText()!= null
        && et_number_of_popular_chair.getText()!= null
        && et_number_of_first_chair.getText() != null
        && et_cost_of_business_chair.getText() != null
        && et_cost_of_special_popular_chair.getText() != null
        && et_cost_of_popular_chair.getText() != null
        && et_cost_of_first_chair.getText() != null) {
            Toast.makeText(getApplicationContext(), "Thêm chuyến bay thành công!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
        }
    }

}
