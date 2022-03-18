package com.example.wallpaperapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WallpaperAdaptor extends RecyclerView.Adapter<WallpaperAdaptor.ViewHolder> {
    private ArrayList<String> wallpaperArrayList;
    private Context context;

    public WallpaperAdaptor(ArrayList<String> wallpaperArrayList, Context context) {
        this.wallpaperArrayList = wallpaperArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public WallpaperAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.wallpaper_rv_item,parent,false);
       return new WallpaperAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperAdaptor.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(wallpaperArrayList.get(position)).into(holder.wallpaperIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,WallpaperActivity.class);
                i.putExtra("imgUrl",wallpaperArrayList.get(position));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wallpaperArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView wallpaperIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wallpaperIV=itemView.findViewById(R.id.idIWWallpaper);
        }
    }
}
