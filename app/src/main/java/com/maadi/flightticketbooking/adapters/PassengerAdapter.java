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
import com.maadi.flightticketbooking.models.PassengerModel;

import java.util.ArrayList;


public class PassengerAdapter extends ArrayAdapter<PassengerModel>  {
    Context context;
    public PassengerAdapter(@NonNull Context context, @NonNull ArrayList<PassengerModel> objects) {
        super(context, 0, objects);
        this.context = context;
    }

    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View userView = convertView;
        if (convertView == null) {
            userView = LayoutInflater.from(context).inflate(R.layout.single_row_passenger,
                    parent, false);
        }

        final PassengerModel user = getItem(position);

        TextView title = userView.findViewById(R.id.name);
        title.setText(user.getName());
        ((TextView)userView.findViewById(R.id.age)).setText(user.getAge() + " tuổi");
        ((TextView)userView.findViewById(R.id.gender)).setText("" + user.getGender());
        ((TextView)userView.findViewById(R.id.type)).setText("" +user.getType());

        return userView;
    }

}