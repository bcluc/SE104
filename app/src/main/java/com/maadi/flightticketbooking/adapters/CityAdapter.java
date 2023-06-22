package com.maadi.flightticketbooking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.maadi.flightticketbooking.R;
import com.maadi.flightticketbooking.models.City;

import java.util.ArrayList;
import java.util.List;


public class CityAdapter extends ArrayAdapter<City> implements Filterable {
    Context context;
    private List<City>originalData = null;
    private List<City>filteredData = null;
    private LayoutInflater mInflater;
    private ItemFilter mFilter = new ItemFilter();
    public CityAdapter(@NonNull Context context, @NonNull List<City> objects) {
        super(context, 0, objects);
        this.context = context;
        this.filteredData = objects ;
        this.originalData = objects ;
    }
    public CityAdapter(@NonNull Context context) {
        super(context, 0);
        this.context = context;
    }

    public int getCount() {
        return filteredData.size();
    }

    public long getItemId(int position) {
        return position;
    }
    public City getItem(int position) {
        return filteredData.get(position);
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View userView = convertView;
        if (convertView == null) {
            userView = LayoutInflater.from(context).inflate(R.layout.single_row_city,
                    parent, false);
        }
        City user = getItem(position);

        TextView etFl = userView.findViewById(R.id.etFl);
        TextView etCName = userView.findViewById(R.id.etCName);

        etFl.setText(user.getCityname().substring(0,1));
        etCName.setText(user.getCityname());
        return userView;
    }

    public Filter getFilter() {
        return mFilter;
    }
    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final List<City> list = originalData;

            int count = list.size();
            final List<City> nlist = new ArrayList<City>(count);

            City city = new City();
            String filterableString ;

            for (int i = 0; i < count; i++) {
                filterableString = list.get(i).getCityname();
                if (filterableString.toLowerCase().contains(filterString)) {
                    nlist.add(list.get(i));
                }
            }
            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<City>) results.values;
            notifyDataSetChanged();
        }

    }
}