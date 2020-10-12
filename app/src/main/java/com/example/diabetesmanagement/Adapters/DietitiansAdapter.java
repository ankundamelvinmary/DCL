package com.example.diabetesmanagement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diabetesmanagement.Models.DietitiansModel;
import com.example.diabetesmanagement.R;

import java.util.List;

public class DietitiansAdapter extends RecyclerView.Adapter<DietitiansAdapter.DietitiansViewHolder> {
    Context context;
    List<DietitiansModel> mData;


    public DietitiansAdapter(Context context,List<DietitiansModel> mData){
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public DietitiansAdapter.DietitiansViewHolder onCreateViewHolder(@NonNull ViewGroup dietitian, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_dietitians,null,false);
        return new DietitiansAdapter.DietitiansViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DietitiansAdapter.DietitiansViewHolder holder, int position) {
        DietitiansModel dietitiansModel = mData.get(position);
        holder.namesholder.setText(mData.get(position).getNames());
        holder.contactholder.setText(mData.get(position).getContact());
        holder.emailholder.setText(mData.get(position).getEmail());
        holder.locationholder.setText(mData.get(position).getLocation());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class DietitiansViewHolder extends RecyclerView.ViewHolder {

        TextView namesholder,contactholder, emailholder, locationholder;
        TextView names,contact, email,location;
        CardView patient_card;

        public DietitiansViewHolder(@NonNull View itemView) {
            super(itemView);
            patient_card = itemView.findViewById(R.id.patient_card);
            namesholder = itemView.findViewById(R.id.namesholder);
            contactholder = itemView.findViewById(R.id.contactholder);
            emailholder = itemView.findViewById(R.id.emailholder);
            locationholder = itemView.findViewById(R.id.locationholder);

            names = itemView.findViewById(R.id.names);
            contact = itemView.findViewById(R.id.contact);
            email = itemView.findViewById(R.id.email);
            location = itemView.findViewById(R.id.location);

        }

    }
}
