package com.example.se104;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class timeAdapter extends RecyclerView.Adapter<timeAdapter.timeViewHolder> {

    private Context mContext;
    private List<time> mListTime;

    public timeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<time> list) {
        this.mListTime = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public timeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.today_time, parent, false);
        return new timeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull timeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mListTime != null) {
            return mListTime.size();
        }
        return 0;
    }

    public class timeViewHolder extends RecyclerView.ViewHolder {
        private TextView time;

        public timeViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
        }
    }

}
