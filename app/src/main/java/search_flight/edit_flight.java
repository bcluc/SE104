package search_flight;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

import java.util.ArrayList;
import java.util.Locale;

import filght_complex.add_flight_complex;
import flight_listview.add_flight;

public class edit_flight  extends AppCompatActivity {
    //    Button btn_open_dialog_flight = findViewById(R.id.hang_hang_ko);
    ArrayList<flight_listview.Contact> list;
    String date;
    int hour, minute;


    flight_listview.Contact selectName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_fight_simple);

        Button btn_open_dialog_flight_continue = findViewById(R.id.next_page);
        Button btn_open_dialog_flight = findViewById(R.id.hang_hang_ko);
        Button btn_open_dialog_lock_start = findViewById(R.id.time_start);
        Button btn_open_dialog_lock_come = findViewById(R.id.time_come);
        Button btn_open_dialog_start_locate = findViewById(R.id.start_locate);
        Button btn_open_dialog_flight_end_locate = findViewById(R.id.end_locate);
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
//                if (!btn_open_dialog_start_locate.getText().toString().equals("Điểm xuất phát")
//                && !btn_open_dialog_flight_end_locate.getText().toString().equals("Điểm đến")
//                        && !btn_open_dialog_flight.getText().toString().equals("Hãng hàng không")
//                        && !btn_open_dialog_lock_come.getText().toString().equals("Thời gian xuất phát")
//                        &&!btn_open_dialog_lock_start.getText().toString().equals("Thời gian đến dự kiến") )
//                {
                Intent intent = new Intent(edit_flight.this, edit_flight_complex.class);
                startActivity(intent);

//                }
//                else
//                    Toast.makeText(getApplicationContext(), "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
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


    private void openFlightListView(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.flight_chooosen);
        View btn_exit = dialog.findViewById(R.id.exit);
        ListView listView;
        listView = (ListView) dialog.findViewById(R.id.list_View);
        list = new ArrayList<>();
        list.add(new flight_listview.Contact("Bamboo"));
        list.add(new flight_listview.Contact("Vietjet air"));
        list.add(new flight_listview.Contact("Vietnam airlines"));
        flight_listview.Adaptor myAdapter;
        myAdapter = new flight_listview.Adaptor(this, list);
        Button btn_open_dialog_flight = findViewById(R.id.hang_hang_ko);
// Khởi tạo đối tượng ArrayAdapter
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectName = (flight_listview.Contact) adapterView.getItemAtPosition(i);
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
        dialog.show();

    }

    private void findLocate(int gravity,int ID) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.locate_of_flight);
        View btn_exit = dialog.findViewById(R.id.exit);
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
        dialog.show();
    }
    public String temp;

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void popTimePicker(View view, int ID) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                setTemp(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
                Button btn = findViewById(ID);
                date = date + "   "+ temp;
                btn.setText(date);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, /*style,*/ onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
        Button btn = findViewById(ID);



    }
    private void openClock(int gravity,int ID) {
//        popTimePicker(findViewById(ID));
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.calender);
        CalendarView mCalendarView;
        Button btn_open_dialog_lock_start = findViewById(ID);

        mCalendarView = (CalendarView) dialog.findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                date = "     " + year + "/" + month + "/"+ dayOfMonth ;
                dialog.dismiss();
                popTimePicker(findViewById(ID),ID);
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
