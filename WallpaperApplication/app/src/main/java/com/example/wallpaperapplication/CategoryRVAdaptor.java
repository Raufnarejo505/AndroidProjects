package com.example.wallpaperapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryRVAdaptor extends RecyclerView.Adapter<CategoryRVAdaptor.ViewHolder> {
    private ArrayList<CategoryRVModel> categoryRVModelArrayList;
    private Context context;
    private CategoryClickInterface categoryClickInterface;

    public CategoryRVAdaptor(ArrayList<CategoryRVModel> categoryRVModelArrayList, Context context, CategoryClickInterface categoryClickInterface) {
        this.categoryRVModelArrayList = categoryRVModelArrayList;
        this.context = context;
        this.categoryClickInterface = categoryClickInterface;
    }

    @NonNull
    @Override
    public CategoryRVAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.category_rv_item,parent,false);
        return new CategoryRVAdaptor.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRVAdaptor.ViewHolder holder, int position) {
            CategoryRVModel categoryRVModel = categoryRVModelArrayList.get(position);
            holder.categoryTV.setText(categoryRVModel.getCategory());
        Glide.with(context).load(categoryRVModel.getGetCategoryIVURl()).into(holder.categoryIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryClickInterface.onCategoryClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView categoryIV;
        private TextView categoryTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryIV= itemView.findViewById(R.id.idIVCategory);
            categoryTV = itemView.findViewById(R.id.idTVCategory);
        }
    }
    public interface CategoryClickInterface{
        void onCategoryClick(int position);
    }
}
