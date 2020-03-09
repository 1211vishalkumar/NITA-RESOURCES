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

public class BranchAdapter extends RecyclerView.Adapter<BranchAdapter.BranchViewholder> {

    ArrayList<String> branches;
    ArrayList<String> details;

    public BranchAdapter(ArrayList<String> branches, ArrayList<String> details) {
        this.branches = branches;
        this.details = details;
    }

    @NonNull
    @Override
    public BranchViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview  = li.inflate(R.layout.list_item_row,parent,false);
        return new BranchViewholder(itemview);

    }

    @Override
    public void onBindViewHolder(@NonNull BranchViewholder holder, final int position) {
        String s = branches.get(position);
        holder.tvSem.setText(s);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> FinalDetails = new ArrayList<>();
                FinalDetails.add(details.get(0));
                FinalDetails.add(branches.get(position));

                Context context = v.getContext();
                Intent intent = new Intent(context,FinalActivity.class);
                intent.putExtra("Anshu",FinalDetails);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return branches.size();
    }

    class BranchViewholder extends RecyclerView.ViewHolder{

        TextView tvSem;
        public final View mView;

        public BranchViewholder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            tvSem = itemView.findViewById(R.id.tvSem);
        }
    }
}
