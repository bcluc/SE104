package com.example.shoppingapp.customerview.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.se104.fragment_home;
import com.example.se104.fragment_notif;
import com.example.se104.fragment_tickets;
import com.example.se104.fragment_user;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fragment_home();

            case 1:
                return new fragment_tickets();

            case 2:
                return new fragment_notif();

            case 3:
                return new fragment_user();

            default:
                return new fragment_home();

        }

    }

    @Override
    public int getCount() {
        return 4;
    }
}
