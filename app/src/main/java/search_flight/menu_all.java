package search_flight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

import flight_listview.add_flight;
import search_flight.SearchByFlightActivity;

public class menu_all extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_all);

        ImageView back = findViewById(R.id.back);
        TextView quanly = findViewById(R.id.quanly);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        quanly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(search_flight.menu_all.this, search_flight.menu_quanly.class));
            }
        });
        TextView update_searvice = findViewById(R.id.update_more_service);
        TextView quanly_ve = findViewById(R.id.quanly_ve);
        TextView flight_brand = findViewById(R.id.brand_info);
        TextView doanhthu = findViewById(R.id.doanhthu);
        TextView phanquyen = findViewById(R.id.account);
        TextView customer = findViewById(R.id.customer);
    }
}
