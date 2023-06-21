import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

public class menu_quanly extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_quanly);
        ImageView back = findViewById(R.id.back);
        TextView add_flight = findViewById(R.id.add_flight);
        TextView search_flight = findViewById(R.id.search_flight);
    }
