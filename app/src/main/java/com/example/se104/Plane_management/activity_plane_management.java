package com.example.se104.Plane_management;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.se104.R;

import java.util.ArrayList;

import Adaptor.Adaptor;
import Class_file.Plane;

public class activity_plane_management extends AppCompatActivity {
    ListView listView;

    ArrayList<Plane> list;
    ImageButton btn_add;

    int index;

    //    ActivityResultLauncher<Intent> launcher;
//    ActivityResultLauncher<Intent> launcherEdit;
    Adaptor myAdapter;

    @Override
    protected void onCreate(Bundle savedInstancesState) {

        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_plane_management);

        listView = findViewById(R.id.lv_plane);
        btn_add= findViewById(R.id.btn_add);

        list = new ArrayList<>();
        //Demo voi du lieu ban dau
        list.add(new Plane("VIETJET", "VJ", "1234578", "123@gmail.com"));
        list.add(new Plane("VIET NAM AIRLINE", "VNA", "787878", "333@gmail.com"));

        myAdapter = new Adaptor(activity_plane_management.this, R.layout.list_plane_item, list);
        listView.setAdapter(myAdapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(activity_plane_management.this, plane_add_activity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(activity_plane_management.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });



    }
}


