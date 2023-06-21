package doanh_thu;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

public class manage_doanh_thu extends AppCompatActivity {

    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tunrover_management);
        TextView date = findViewById(R.id.calender);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClock(Gravity.BOTTOM);
            }
        });
    }
    private void openClock(int gravity) {
//        popTimePicker(findViewById(ID));
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_doanhthu);
        Button day_start = dialog.findViewById(R.id.day_start);
        Button day_end = dialog.findViewById(R.id.day_end);
        day_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_calender(Gravity.BOTTOM,day_start);
            }

            private void set_calender(int gravity,Button day) {
//        popTimePicker(findViewById(ID));
                final Dialog dialog = new Dialog(manage_doanh_thu.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.calender);
                CalendarView mCalendarView;

                mCalendarView = (CalendarView) dialog.findViewById(R.id.calendarView);
                mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                        date = "     " + year + "/" + month + "/"+ dayOfMonth ;
                        day.setText(date);
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