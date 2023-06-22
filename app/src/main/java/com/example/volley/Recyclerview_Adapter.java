package com.example.volley;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.RecyclerviewHolder> {
    MainActivity mainActivity;
    ArrayList<Photos_Modal> list;
    public Recyclerview_Adapter(MainActivity mainActivity, ArrayList<Photos_Modal> list) {
        this.mainActivity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public Recyclerview_Adapter.RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.recyclerview_item,parent,false);
        RecyclerviewHolder holder = new RecyclerviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Adapter.RecyclerviewHolder holder, int position) {
        Log.d("GGG", "onBindViewHolder: id "+list.get(position).getId());
        holder.id1.setText("ID : "+""+list.get(position).getId());
        holder.userid.setText("UserID : "+""+list.get(position).getAlbumId());
        holder.title1.setText("Title : "+list.get(position).getTitle());
//         Glide.with(mainActivity)
//               .load(list.get(position).getUrl()).centerCrop()
//               .placeholder(R.drawable.animation)
//               .into(holder.url);

           Picasso.get()
                 .load(list.get(position).getUrl())
                 .placeholder(R.drawable.animation)
                 .into(holder.url);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView id1,userid,title1;
        ImageView url;
        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            id1 = itemView.findViewById(R.id.id1);
            userid = itemView.findViewById(R.id.userid);
            title1 = itemView.findViewById(R.id.title1);
            url = itemView.findViewById(R.id.url);
        }
    }
}
