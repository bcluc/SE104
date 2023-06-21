package com.example.se104;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.shoppingapp.customerview.fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class navigation_bottom extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager view_pager;
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
//    private void replaceFragment(Fragment fragment){
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frameLayout,fragment);
//        fragmentTransaction.commit();
//    }
}