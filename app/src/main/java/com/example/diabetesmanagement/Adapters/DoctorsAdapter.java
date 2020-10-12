package com.example.diabetesmanagement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diabetesmanagement.Models.DoctorsModel;
import com.example.diabetesmanagement.R;

import java.util.List;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.PatientsViewHolder> {
    Context context;
    List<DoctorsModel> mData;


    public DoctorsAdapter (Context context,List<DoctorsModel> mData){
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public DoctorsAdapter.PatientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_patients,null,false);
        return new PatientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsAdapter.PatientsViewHolder holder, int position) {
        DoctorsModel doctorsModel = mData.get(position);
        holder.fullnamesholder.setText(mData.get(position).getFirstname());
        holder.ageholder.setText(mData.get(position).getAge());
        holder.sexholder.setText(mData.get(position).getSex());
        holder.contactholder.setText(mData.get(position).getContact());
        holder.emailholder.setText(mData.get(position).getEmail());
        holder.districtholder.setText(mData.get(position).getDistrict());
        holder.hospitalholder.setText(mData.get(position).getHospital());
       // holder.occupationholder.setText(mData.get(position).getOccupation());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PatientsViewHolder extends RecyclerView.ViewHolder {

        TextView fullnamesholder,ageholder,sexholder,contactholder,emailholder,districtholder,hospitalholder;
        TextView fullnames,age,sex,contact,email,district,hospital;
        CardView doctor_card;

        public PatientsViewHolder(@NonNull View itemView) {
            super(itemView);
            doctor_card = itemView.findViewById(R.id.doctor_card);
            fullnamesholder = itemView.findViewById(R.id.fullnamesholder);
            ageholder = itemView.findViewById(R.id.ageholder);
            sexholder = itemView.findViewById(R.id.sexholder);
            contactholder = itemView.findViewById(R.id.contactholder);
            emailholder = itemView.findViewById(R.id.emailholder);
            districtholder = itemView.findViewById(R.id.districtholder);
            hospitalholder = itemView.findViewById(R.id.hospitalholder);
            //occupationholder = itemView.findViewById(R.id.occupationholder);

            fullnames = itemView.findViewById(R.id.fullnames);
            age = itemView.findViewById(R.id.age);
            sex = itemView.findViewById(R.id.sex);
            contact = itemView.findViewById(R.id.contact);
            email = itemView.findViewById(R.id.email);
            district = itemView.findViewById(R.id.district);
            hospital = itemView.findViewById(R.id.hospital);
            //occupation = itemView.findViewById(R.id.occupation);
        }
    }
}
