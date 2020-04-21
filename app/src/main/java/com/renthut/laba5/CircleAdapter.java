package com.renthut.laba5;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CircleAdapter extends RecyclerView.Adapter<CircleAdapter.CircleViewHolder> {

    public interface OnItemClickListener {
        void onItemClicked(String number);
    }

    private List<Circle> list;
    private OnItemClickListener mListener;

    public CircleAdapter(List<Circle> list, OnItemClickListener mListener) {
        this.list = list;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public CircleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CircleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CircleViewHolder holder, int position) {
        holder.circle.setCardBackgroundColor(
                holder.itemView
                        .getContext()
                        .getResources()
                        .getColor(list.get(position).getColor())
        );
        holder.number.setText(String.valueOf(list.get(position).getNumber()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CircleViewHolder extends RecyclerView.ViewHolder {
        public TextView number;
        public CardView circle;

        CircleViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);
            circle = itemView.findViewById(R.id.circle_view);

            itemView.setOnClickListener(v -> {
                mListener.onItemClicked(number.getText().toString());
            });
        }
    }
}
