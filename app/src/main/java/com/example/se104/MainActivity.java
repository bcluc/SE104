package com.example.se104;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView flight_ticket;
    private TicketAdapter ticketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_trip);

        flight_ticket = findViewById(R.id.flight_list);
        ticketAdapter = new TicketAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        flight_ticket.setLayoutManager(linearLayoutManager);

        ticketAdapter.setData(getListTicket());

        flight_ticket.setAdapter(ticketAdapter);
    }

    private List<Ticket> getListTicket() {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(new Ticket("HAN", "09:00", "7h00p", "ICN", "15:00", "5.000.000", "Còn 3 chỗ"));
        ticketList.add(new Ticket("SGN", "07:00", "2h30p", "HAN", "09:30", "1.500.000", "Còn 10 chỗ"));
        return ticketList;

    }

}


