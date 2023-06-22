package com.example.se104;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class choose_trip extends AppCompatActivity {

    Button nextButton;
    Button backButton;

    private RecyclerView flight_ticket;
    private RecyclerView time;
    private TicketAdapter ticketAdapter;
    private timeAdapter timeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_trip);

        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(choose_trip.this, check_out.class);
                    startActivity(intent);
            }
        });

        backButton = (Button) findViewById(R.id.out_arrow);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(choose_trip.this, navigation_bottom.class);
                    startActivity(intent);
            }
        });

        flight_ticket = findViewById(R.id.flight_list);
        ticketAdapter = new TicketAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        flight_ticket.setLayoutManager(linearLayoutManager);

        ticketAdapter.setData(getListTicket());

        flight_ticket.setAdapter(ticketAdapter);

        time = findViewById(R.id.today_time);
        timeAdapter = new timeAdapter(this);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        time.setLayoutManager(linearLayoutManager1);

        timeAdapter.setData(getListTime());

    }

    private List<Ticket> getListTicket() {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(new Ticket("HAN", "09:00", "7h00p", "ICN", "15:00", "5.000.000", "Còn 3 chỗ"));
        ticketList.add(new Ticket("SGN", "07:00", "2h30p", "HAN", "09:30", "1.500.000", "Còn 10 chỗ"));
        ticketList.add(new Ticket("HAN", "09:00", "7h00p", "ICN", "15:00", "5.000.000", "Còn 3 chỗ"));
        ticketList.add(new Ticket("SGN", "07:00", "2h30p", "HAN", "09:30", "1.500.000", "Còn 10 chỗ"));
        ticketList.add(new Ticket("HAN", "09:00", "7h00p", "ICN", "15:00", "5.000.000", "Còn 3 chỗ"));
        ticketList.add(new Ticket("SGN", "07:00", "2h30p", "HAN", "09:30", "1.500.000", "Còn 10 chỗ"));
        ticketList.add(new Ticket("HAN", "09:00", "7h00p", "ICN", "15:00", "5.000.000", "Còn 3 chỗ"));
        ticketList.add(new Ticket("SGN", "07:00", "2h30p", "HAN", "09:30", "1.500.000", "Còn 10 chỗ"));
        return ticketList;

    }

    private List<time> getListTime(){
        List<time> timeList = new ArrayList<>();
        timeList.add(new time("CN 19/10/2023"));
        timeList.add(new time("T2 20/10/2023"));
        timeList.add(new time("CN 19/10/2023"));
        timeList.add(new time("T2 20/10/2023"));
        timeList.add(new time("CN 19/10/2023"));
        timeList.add(new time("T2 20/10/2023"));
        return timeList;
    }

}
