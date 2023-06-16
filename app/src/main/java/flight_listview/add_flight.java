package flight_listview;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

import java.util.ArrayList;

public class add_flight  extends AppCompatActivity {
//    Button btn_open_dialog_flight = findViewById(R.id.hang_hang_ko);
    ArrayList<Contact> list;


    Contact selectName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addfight);

        Button btn_open_dialog_flight = findViewById(R.id.hang_hang_ko);
//        Button btn_open_dialog_lock_start = findViewById(R.id.time_start);
//        Button btn_open_dialog_lock_come = findViewById(R.id.time_come);
//        Button btn_open_dialog_start_locate = findViewById(R.id.start_locate);
//        Button btn_open_dialog_flight_end_locate = findViewById(R.id.end_locate);
//        Button btn_open_dialog_flight_continue = findViewById(R.id.next_page);

        btn_open_dialog_flight.setOnClickListener(new View.OnClickListener() {
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
        ListView listView;
        listView = (ListView) dialog.findViewById(R.id.list_View);
        list = new ArrayList<>();
        list.add(new Contact("Bamboo"));
        list.add(new Contact("Vietjet air"));
        list.add(new Contact("Vietnam airlines"));
        Adaptor myAdapter;
        myAdapter = new Adaptor(this, list);
            Button btn_open_dialog_flight = findViewById(R.id.hang_hang_ko);
// Khởi tạo đối tượng ArrayAdapter
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectName = (Contact) adapterView.getItemAtPosition(i);
            }
        });

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
                btn_open_dialog_flight.setText(selectName.getName());
                dialog.dismiss();
            }
        });

        dialog.show();
        }
//        protected void onCreate(@Nullable Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.addfight);
//        }
    }
