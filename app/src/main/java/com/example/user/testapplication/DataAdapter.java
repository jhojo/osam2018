package com.example.user.testapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<DataFormat> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    DataAdapter(List<DataFormat> data) {
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent, false);
        return new ViewHolder(v);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataFormat data = mData.get(position);
        holder.data1.setText(data.data1);
        holder.data2.setText(data.data2);
        holder.data3.setText(data.data3);
        holder.data4.setText(data.data4);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView data1;
        TextView data2;
        TextView data3;
        TextView data4;
        int x;
        int y;
        ViewHolder(View itemView) {
            super(itemView);
            data1 = itemView.findViewById(R.id.type1);
            data2 = itemView.findViewById(R.id.type2);
            data3 = itemView.findViewById(R.id.type3);
            data4 = itemView.findViewById(R.id.type4);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}