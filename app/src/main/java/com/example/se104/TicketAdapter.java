package com.example.se104;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {
    private Context mContext;
    private List<Ticket> mListTicket;

    public TicketAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Ticket> list) {
        this.mListTicket = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_ticket, parent, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
        Ticket ticket = mListTicket.get(position);
        if (ticket == null) {
            return;
        }
        holder.departure_point.setText(ticket.getDeparture_point());
        holder.departure_time.setText(ticket.getDeparture_time());

        holder.flight_time.setText(ticket.getFlight_time());

        holder.destination_point.setText(ticket.getDestination_point());
        holder.destination_time.setText(ticket.getDestination_time());

        holder.ticket_price.setText(ticket.getTicket_price());
        holder.space_seat.setText(ticket.getSpace_seat());
    }

    @Override
    public int getItemCount() {
        if (mListTicket != null) {
            return mListTicket.size();
        }
        return 0;
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder {
        private TextView departure_point;
        private TextView departure_time;

        private TextView flight_time;

        private TextView destination_point;
        private TextView destination_time;

        private TextView ticket_price;
        private TextView space_seat;


        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);

            departure_point = itemView.findViewById(R.id.departure_point);
            departure_time = itemView.findViewById(R.id.departure_time);

            flight_time = itemView.findViewById(R.id.flight_time);

            destination_point = itemView.findViewById(R.id.destination_point);
            destination_time = itemView.findViewById(R.id.destination_time);

            ticket_price = itemView.findViewById(R.id.ticket_price);
            space_seat = itemView.findViewById(R.id.space_seat);
        }
    }

}
