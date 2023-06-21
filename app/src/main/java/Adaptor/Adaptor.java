package Adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.se104.Plane_management.plane_edit_activity;
import com.example.se104.R;

import java.util.ArrayList;

import Class_file.Plane;

public class Adaptor extends ArrayAdapter<Plane> {

    private Context context;

    private ArrayList<Plane> list;
    private int resource;
    public Adaptor(@Nullable Context context, int resource, ArrayList<Plane> list) {
        super(context, resource,list);
        this.context= context;
        this.resource= resource;
        this.list= list;

    }

    @Nullable

    public Plane GetPosition (int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        LayoutInflater inflater =LayoutInflater.from(context.getApplicationContext());

        View tempView = inflater.inflate(R.layout.list_plane_item, viewGroup, false);

        TextView plane_name= tempView.findViewById(R.id.txt_plane_name);
        plane_name.setText(list.get(i).getPlane_Name());
        ImageButton btn_edit = tempView.findViewById(R.id.btn_edit);
        ImageButton btn_delete = tempView.findViewById(R.id.btn_delete);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getContext(), plane_edit_activity.class));
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(i);
                notifyDataSetChanged();
            }
        });

        return tempView;

    }

}
