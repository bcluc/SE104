package com.example.se104;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.shoppingapp.customerview.fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.text.DateFormat;
import java.util.Calendar;

public class navigation_bottom extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private BottomNavigationView bottomNavigationView;
    private ViewPager view_pager;
    private int ck_day = 0;
    private TextView tv_day;
    private TextView tv_day_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.navigation_bottom);
        super.onCreate(savedInstanceState);

        view_pager = findViewById(R.id.viewpager_bottomNavi);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        ViewPagerAdapter adapter = new com.example.shoppingapp.customerview.fragment.ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        view_pager.setAdapter(adapter);

        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        break;

                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.tickets).setChecked(true);
                        break;

                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.notif).setChecked(true);
                        break;

                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.user).setChecked(true);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        view_pager.setCurrentItem(0);
                        break;

                    case R.id.tickets:
                        view_pager.setCurrentItem(1);
                        break;

                    case R.id.notif:
                        view_pager.setCurrentItem(2);
                        break;

                    case R.id.user:
                        view_pager.setCurrentItem(3);
                        break;
                }

                return true;
            }
        });
    }

    public void goto_message_activity()
    {
        Intent intent = new Intent(navigation_bottom.this, activity_message.class);
        startActivity(intent);
    }
    public void goto_find_flights_activity()
    {
        Intent intent = new Intent(navigation_bottom.this, MainActivity.class);
        startActivity(intent);
    }

    public void choose_day_go_activity(TextView day)
    {
        tv_day = day;
        DialogFragment datePicker = new fragment_datepicker();
        datePicker.show(getSupportFragmentManager(), "Date Picker");
    }
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        String currentDateString = DateFormat.getDateInstance(DateFormat.DEFAULT).format(c.getTime());
        tv_day.setText(currentDateString);
    }
}