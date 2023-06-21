package search_flight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

import flight_listview.add_flight;

public class menu_quanly extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_quanly);
        ImageView back = findViewById(R.id.back);
        TextView add_flight_txt = findViewById(R.id.add_flight);
        TextView search_flight_txt = findViewById(R.id.search_flight);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        add_flight_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu_quanly.this, add_flight.class));
            }
        });
        search_flight_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu_quanly.this, SearchByFlightActivity.class));
            }
        });
    }
}
