package add_flight;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

public class add_flight  extends AppCompatActivity {
    Button btn_open_dialog_flight_choosen = findViewById(R.id.hang_hang_ko);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addfight);

//        Button btn_open_dialog_flight_choosen = findViewById(R.id.hang_hang_ko);
        Button btn_open_dialog_lock_start = findViewById(R.id.time_start);
        Button btn_open_dialog_lock_come = findViewById(R.id.time_come);
        Button btn_open_dialog_start_locate = findViewById(R.id.start_locate);
        Button btn_open_dialog_flight_end_locate = findViewById(R.id.end_locate);
        Button btn_open_dialog_flight_continue = findViewById(R.id.next_page);

        btn_open_dialog_flight_choosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFlightListView(Gravity.BOTTOM);
            }
        });
    }

    private void openFlightListView(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.flight_chooosen);

        Window window = dialog.getWindow();
        if (window == null)
        {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        }else{
             dialog.setCancelable(true);
            }
        Button btn_continue = dialog.findViewById(R.id.continue_fill);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_open_dialog_flight_choosen.setText();
            }
        });

        dialog.show();
        }
    }
