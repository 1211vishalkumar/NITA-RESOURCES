package com.example.nitaexams;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SemAdapter extends RecyclerView.Adapter<SemAdapter.SemViewholder> {

    ArrayList<String> semesters;

    public SemAdapter(ArrayList<String> semesters) {
        this.semesters = semesters;
    }

    @NonNull
    @Override
    public SemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview  = li.inflate(R.layout.list_item_row,parent,false);
        return new SemViewholder(itemview);

    }

    @Override
    public void onBindViewHolder(@NonNull SemViewholder holder, final int position) {
        String s = semesters.get(position);
        holder.tvSem.setText(s);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent i = new Intent(context,BranchActivity.class);

                String result = semesters.get(position);
                i.putExtra("Vishal",result);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return semesters.size();
    }

    class SemViewholder extends RecyclerView.ViewHolder{

        TextView tvSem;
        public final View mView;

        public SemViewholder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            tvSem = itemView.findViewById(R.id.tvSem);
        }
    }
}
