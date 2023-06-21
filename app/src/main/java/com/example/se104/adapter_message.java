package com.example.se104;;

import static com.example.se104.R.drawable.bg_message_blue;
import static com.example.se104.R.drawable.bg_message_white;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_message extends RecyclerView.Adapter<adapter_message.MessageViewHolder>{

    private List<obj_message> objmessageList;
    private Context context;

    public adapter_message(Context context)
    {
        this.context = context;
    }

    public void setData(List<obj_message> objmessageList)
    {
        this.objmessageList = objmessageList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);


        return new MessageViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        obj_message objmessage = objmessageList.get(position);
        if(objmessage == null) return;

        holder.txtContentMessage.setText(objmessage.getContent());
        holder.txtTimeMessage.setText(objmessage.getTime());
        if (objmessage.getType() == 1)
        {
            holder.layout_message_item.setGravity(Gravity.RIGHT);
            holder.layout_rowMessage.setBackgroundResource(bg_message_blue);
            holder.txtContentMessage.setTextColor((ContextCompat.getColor(context,R.color.white)));
            holder.txtTimeMessage.setTextColor((ContextCompat.getColor(context,R.color.white)));
        }else {
            holder.layout_message_item.setGravity(Gravity.LEFT);
            holder.layout_rowMessage.setBackgroundResource(bg_message_white);
            holder.txtContentMessage.setTextColor((ContextCompat.getColor(context,R.color.black)));
            holder.txtTimeMessage.setTextColor((ContextCompat.getColor(context,R.color.black)));
        }


    }

    @Override
    public int getItemCount() {
        if (objmessageList != null) return objmessageList.size();
        return 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout layout_message_item;
        private LinearLayout layout_rowMessage;
        private TextView txtContentMessage;
        private TextView txtTimeMessage;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);

            layout_message_item = itemView.findViewById(R.id.layout_message_item);
            layout_rowMessage = itemView.findViewById(R.id.layout_rowMessage);
            txtContentMessage = itemView.findViewById(R.id.txtContentMessage);
            txtTimeMessage = itemView.findViewById(R.id.txtTimeMessage);
        }
    }
}
