package com.example.diabetesmanagement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diabetesmanagement.Models.PatientsModel;
import com.example.diabetesmanagement.R;

import java.util.List;

public class PatientsAdapter extends RecyclerView.Adapter<PatientsAdapter.PatientsViewHolder> {
    Context context;
    List<PatientsModel> mData;


    public PatientsAdapter (Context context,List<PatientsModel> mData){
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public PatientsAdapter.PatientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_patients,null,false);
        return new PatientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientsAdapter.PatientsViewHolder holder, int position) {
        PatientsModel patientsModel = mData.get(position);
        holder.fullnamesholder.setText(mData.get(position).getName());
        holder.ageholder.setText(mData.get(position).getAge());
        holder.districtholder.setText(mData.get(position).getDistrict());
        holder.occupationholder.setText(mData.get(position).getOccupation());
        holder.glucoseholder.setText(mData.get(position).getGlucose());
        holder.bmiholder.setText(mData.get(position).getBmi());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PatientsViewHolder extends RecyclerView.ViewHolder {

        TextView fullnamesholder,ageholder,districtholder,occupationholder,glucoseholder,bmiholder;
        TextView fullnames,age,district,occupation,glucose,bmi;
        CardView patient_card;

        public PatientsViewHolder(@NonNull View itemView) {
            super(itemView);

            patient_card = itemView.findViewById(R.id.patient_card);
            fullnamesholder = itemView.findViewById(R.id.fullnamesholder);
            ageholder = itemView.findViewById(R.id.ageholder);
            districtholder = itemView.findViewById(R.id.districtholder);
            occupationholder = itemView.findViewById(R.id.occupationholder);
            glucoseholder = itemView.findViewById(R.id.glucoseholder);
            bmiholder = itemView.findViewById(R.id.bmiholder);

            fullnames = itemView.findViewById(R.id.fullnames);
            age = itemView.findViewById(R.id.age);
            district = itemView.findViewById(R.id.district);
            occupation = itemView.findViewById(R.id.occupation);
            glucose = itemView.findViewById(R.id.glucose);
            bmi = itemView.findViewById(R.id.bmi);
        }
    }
}
