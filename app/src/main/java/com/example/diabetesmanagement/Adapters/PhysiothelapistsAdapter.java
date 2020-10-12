package com.example.diabetesmanagement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diabetesmanagement.Models.PhysiothelapistsModel;
import com.example.diabetesmanagement.R;

import java.util.List;

public class PhysiothelapistsAdapter extends RecyclerView.Adapter<PhysiothelapistsAdapter.PhysiothelapistViewHolder>{
    Context context;
    List<PhysiothelapistsModel> mData;


    public PhysiothelapistsAdapter (Context context,List<PhysiothelapistsModel> mData){
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public PhysiothelapistsAdapter.PhysiothelapistViewHolder onCreateViewHolder(@NonNull ViewGroup nurse, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_physiothelapists,null,false);
        return new PhysiothelapistsAdapter.PhysiothelapistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhysiothelapistsAdapter.PhysiothelapistViewHolder holder, int position) {
        PhysiothelapistsModel physiothelapistsModel = mData.get(position);
        holder.fullnamesholder.setText(mData.get(position).getFullnames());
        holder.contactholder.setText(mData.get(position).getContact());
        holder.emailholder.setText(mData.get(position).getEmail());
        holder.locationholder.setText(mData.get(position).getLocation());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PhysiothelapistViewHolder extends RecyclerView.ViewHolder {

        TextView fullnamesholder,contactholder, emailholder, locationholder;
        TextView fullnames,contact, email,location;
        CardView patient_card;

        public PhysiothelapistViewHolder(@NonNull View itemView) {
            super(itemView);
            patient_card = itemView.findViewById(R.id.patient_card);
            fullnamesholder = itemView.findViewById(R.id.fullnamesholder);
            contactholder = itemView.findViewById(R.id.contactholder);
            emailholder = itemView.findViewById(R.id.emailholder);
            locationholder = itemView.findViewById(R.id.locationholder);

            fullnames = itemView.findViewById(R.id.fullnames);
            contact = itemView.findViewById(R.id.contact);
            email = itemView.findViewById(R.id.email);
            location = itemView.findViewById(R.id.location);

        }

    }
}
