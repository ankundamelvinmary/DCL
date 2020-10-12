package com.example.diabetesmanagement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diabetesmanagement.Models.NursesModel;
import com.example.diabetesmanagement.R;

import java.util.List;

public class NursesAdapter extends RecyclerView.Adapter<NursesAdapter.PatientsViewHolder> {
    Context context;
    List<NursesModel> mData;


    public NursesAdapter (Context context,List<NursesModel> mData){
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public NursesAdapter.PatientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_nurses,null,false);
        return new PatientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NursesAdapter.PatientsViewHolder holder, int position) {
        NursesModel nursesModel = mData.get(position);
        holder.firstnameholder.setText(mData.get(position).getFirstname());
        holder.ageholder.setText(mData.get(position).getAge());
        holder.sexholder.setText(mData.get(position).getSex());
        holder.contactholder.setText(mData.get(position).getContact());
        holder.lastnameholder.setText(mData.get(position).getLastname());
        holder.districtholder.setText(mData.get(position).getDistrict());
        holder.hospitalholder.setText(mData.get(position).getHospital());
        holder.emailholder.setText(mData.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PatientsViewHolder extends RecyclerView.ViewHolder {

        TextView firstnameholder,ageholder,sexholder,contactholder,lastnameholder,districtholder,emailholder,hospitalholder;
        TextView firstname,age,sex,contact,lastname,district,email,hospital;
        CardView patient_card;

        public PatientsViewHolder(@NonNull View itemView) {
            super(itemView);

            patient_card = itemView.findViewById(R.id.patient_card);
            firstnameholder = itemView.findViewById(R.id.firstnameholder);
            ageholder = itemView.findViewById(R.id.ageholder);
            sexholder = itemView.findViewById(R.id.sexholder);
            contactholder = itemView.findViewById(R.id.contactholder);
            lastnameholder = itemView.findViewById(R.id.lastnameholder);
            districtholder = itemView.findViewById(R.id.districtholder);
            emailholder = itemView.findViewById(R.id.emailholder);
            hospitalholder = itemView.findViewById(R.id.hospitalholder);

            firstname = itemView.findViewById(R.id.firstname);
            age = itemView.findViewById(R.id.age);
            sex = itemView.findViewById(R.id.sex);
            contact = itemView.findViewById(R.id.contact);
            lastname = itemView.findViewById(R.id.lastname);
            district = itemView.findViewById(R.id.district);
            email = itemView.findViewById(R.id.emailholder);
            hospital = itemView.findViewById(R.id.hospital);
        }
    }
}
