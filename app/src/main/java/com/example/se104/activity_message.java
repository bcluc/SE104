package com.example.se104;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class activity_message extends AppCompatActivity {

    RecyclerView rcvMessage;
    List<obj_message> objmessageList;
    adapter_message adaptermessage;
    Button btn_back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        rcvMessage = findViewById(R.id.rcvMessage);
        btn_back = findViewById(R.id.btn_back_message);

        objmessageList = new ArrayList<>();
        objmessageList.add(new obj_message(1, "Em chào anhh", "11:30"));
        objmessageList.add(new obj_message(2, "Chào emmm", "11:30"));
        objmessageList.add(new obj_message(1, "Anh cóa người yêu chưa ạ!", "11:30"));
        objmessageList.add(new obj_message(2, "Chưa em nhé", "11:30"));
        objmessageList.add(new obj_message(1, "Thế làm người yêu em nhé, em thích anh quá điiiii", "11:30"));
        objmessageList.add(new obj_message(1, "<3", "11:30"));
        objmessageList.add(new obj_message(2, "Oke em oi", "11:30"));


        adaptermessage = new adapter_message(this.getApplicationContext());
        adaptermessage.setData(objmessageList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rcvMessage.setLayoutManager(linearLayoutManager);

        rcvMessage.setAdapter(adaptermessage);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_message.this,navigation_bottom.class);
                startActivity(intent);
            }
        });
    }
}