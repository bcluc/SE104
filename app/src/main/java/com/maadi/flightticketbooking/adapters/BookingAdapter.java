package com.maadi.flightticketbooking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.models.MyBooking;


public class BookingAdapter extends ArrayAdapter<MyBooking>  {
    Context context;
    public BookingAdapter(@NonNull Context context, @NonNull MyBooking[]  objects) {
        super(context, 0, objects);
        this.context = context;
    }

    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View userView = convertView;
        if (convertView == null) {
            userView = LayoutInflater.from(context).inflate(R.layout.single_row_booking,
                    parent, false);
        }

        final MyBooking user = getItem(position);

        ((TextView)userView.findViewById(R.id.tvFrom)).setText(user.getFromcity());
        ((TextView)userView.findViewById(R.id.tvTo)).setText(user.getTocity());
        ((TextView)userView.findViewById(R.id.tvDep)).setText("Ngày : " +user.getTraveldate());
        ((TextView)userView.findViewById(R.id.tvArival)).setText(user.getVclass() + " Class");
        ((TextView)userView.findViewById(R.id.tvFare)).setText("Giá : "+user.getFare());
        return userView;
    }

}