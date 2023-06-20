package com.example.se104;

import android.content.Context;
import android.text.NoCopySpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class adapter_Airline_Brand extends ArrayAdapter<object_Airline_Brand> {
    public adapter_Airline_Brand(Context context, ArrayList<object_Airline_Brand> arrayList){
        super(context,0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }
    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_spinner_des, parent,false
            );
        }

        TextView tv_id = convertView.findViewById(R.id.txt_des_id);
        TextView tv_name = convertView.findViewById(R.id.txt_des_name);

        object_Airline_Brand currentItem = getItem(position);

        if(currentItem != null) {
            tv_id.setText(currentItem.getID());
            tv_name.setText(currentItem.getName());
        }
        return convertView;
    }
}
