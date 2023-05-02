package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.name.setText(user.getAd());
        holder.email.setText(user.getGecmis());
        holder.age.setText(user.getYas());
        holder.itemView.setOnClickListener(view ->{
            Intent intent = new Intent(context, MainActivity3.class);
            intent.putExtra("isim",list.get(position).getAd());
            intent.putExtra("yas",list.get(position).getYas());
            intent.putExtra("tel",list.get(position).getTel());
            intent.putExtra("diller",list.get(position).getDiller());
            intent.putExtra("gecmis",list.get(position).getGecmis());
            intent.putExtra("posta",list.get(position).getPosta());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static  class MyViewHolder extends  RecyclerView.ViewHolder{
TextView name,email,age;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tvlast);
            email=itemView.findViewById(R.id.tvfirst);
            age=itemView.findViewById(R.id.tvage);
        }
    }
}
