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
import com.maadi.flightticketbooking.models.Vehical;


public class VehicleAdapter extends ArrayAdapter<Vehical>  {
    Context context;
    public VehicleAdapter(@NonNull Context context, @NonNull Vehical[]  objects) {
        super(context, 0, objects);
        this.context = context;
    }

    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View userView = convertView;
        if (convertView == null) {
            userView = LayoutInflater.from(context).inflate(R.layout.single_row_vehicle,
                    parent, false);
        }

        final Vehical user = getItem(position);
        TextView title = userView.findViewById(R.id.title);
        title.setText(user.getVehicle_name());
        ((TextView)userView.findViewById(R.id.tvFrom)).setText(user.getFromcity());
        ((TextView)userView.findViewById(R.id.tvTo)).setText(user.getTocity());
        ((TextView)userView.findViewById(R.id.tvDep)).setText(user.getDeptime());
        ((TextView)userView.findViewById(R.id.tvArival)).setText(user.getArivaltime());
        ((TextView)userView.findViewById(R.id.tvFare)).setText(user.getEfare()+" VND");
        return userView;
    }

}