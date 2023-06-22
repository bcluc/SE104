package flight_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.se104.R;

import java.util.ArrayList;

public class Adaptor extends ArrayAdapter<Contact> {
    private Context context;
    private ArrayList<Contact> list;

    public Adaptor(Context context,ArrayList<Contact> list) {
        super(context, R.layout.item_flight_listview, list);
        this.context = context;
        this.list = list;
    }
    
    @Nullable
    @Override
    public Contact getItem(int position) {
        return super.getItem(position);
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());

        View tempView = inflater.inflate(R.layout.item_flight_listview, viewGroup, false);

        TextView name = tempView.findViewById(R.id.name);
        name.setText(list.get(i).getName());

        return tempView;
    }


}

