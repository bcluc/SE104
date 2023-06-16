package flight_listview;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.MainActivity;
import com.example.se104.R;

import java.util.ArrayList;
import java.util.Locale;

public class add_flight  extends AppCompatActivity {
//    Button btn_open_dialog_flight = findViewById(R.id.hang_hang_ko);
    ArrayList<Contact> list;
    String date;
    int hour, minute;


    Contact selectName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addfight);

        Button btn_open_dialog_flight = findViewById(R.id.hang_hang_ko);
        Button btn_open_dialog_lock_start = findViewById(R.id.time_start);
        Button btn_open_dialog_lock_come = findViewById(R.id.time_come);
        Button btn_open_dialog_start_locate = findViewById(R.id.start_locate);
        Button btn_open_dialog_flight_end_locate = findViewById(R.id.end_locate);
        Button btn_open_dialog_flight_continue = findViewById(R.id.next_page);

        btn_open_dialog_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFlightListView(Gravity.BOTTOM);
            }
        });

        btn_open_dialog_lock_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openClock(Gravity.BOTTOM,R.id.time_start);
            }
        });
        btn_open_dialog_lock_come.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openClock(Gravity.BOTTOM,R.id.time_come);
            }
        });
        btn_open_dialog_start_locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findLocate(Gravity.BOTTOM,R.id.start_locate);
            }
        });
        btn_open_dialog_flight_end_locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findLocate(Gravity.BOTTOM,R.id.end_locate);
            }
        });
        btn_open_dialog_flight_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_open_dialog_start_locate != null
                && btn_open_dialog_flight_end_locate != null
                && btn_open_dialog_flight != null
                && btn_open_dialog_lock_come != null
                && btn_open_dialog_lock_start != null)
                {
                    Intent intent = new Intent(add_flight.this, add_flight_complex.class);
                    startActivity(intent);
                }
            }
        });

    }


    private void openFlightListView(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.flight_chooosen);
        View btn_exit = dialog.findViewById(R.id.exit);
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
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
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

    }

    private void findLocate(int gravity,int ID) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.locate_of_flight);
        View btn_exit = dialog.findViewById(R.id.exit);
        Adaptor myAdapter;
        myAdapter = new Adaptor(this, list);
        Button btn_open_dialog_flight = findViewById(ID);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
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
                EditText editText = dialog.findViewById(R.id.input_locate);
                btn_open_dialog_flight.setText(editText.getText().toString());
                dialog.dismiss();
            }
        });

    }

    public void popTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                date = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, /*style,*/ onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
    private void openClock(int gravity,int ID) {
        popTimePicker(findViewById(ID));
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.calender);
        CalendarView mCalendarView;
        Button btn_open_dialog_lock_start = findViewById(ID);

        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                date = date + "     " + year + "/" + month + "/"+ dayOfMonth ;
                btn_open_dialog_lock_start.setText(date);
                dialog.dismiss();
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

        dialog.show();
    }
//        protected void onCreate(@Nullable Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.addfight);
//        }
    }
