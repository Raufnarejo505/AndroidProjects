package com.example.wallpaperapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CategoryRVAdaptor.CategoryClickInterface {

    private EditText searchEdt;
    private ImageView searchIV;
    private RecyclerView categoryRV,wallpaperRV;
    private ProgressBar loadingPB;
    private ArrayList<String> wallpaperArrayList;
    private ArrayList<CategoryRVModel> categoryRVModelArrayList;
    private CategoryRVAdaptor categoryRVAdaptor;
    private WallpaperAdaptor wallpaperAdaptor;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchEdt=findViewById(R.id.idEditSearch);
        categoryRV=findViewById(R.id.idRLCategory);
        searchIV=findViewById(R.id.idIVSearch);
        wallpaperRV=findViewById(R.id.idRLWallpapers);
        loadingPB=findViewById(R.id.idPBLoading);
        wallpaperArrayList = new ArrayList<>();
        categoryRVModelArrayList=new ArrayList<>();
         LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false);
         categoryRV.setLayoutManager(linearLayoutManager);
            categoryRVAdaptor=new CategoryRVAdaptor(categoryRVModelArrayList,this,this::onCategoryClick);
            categoryRV.setAdapter(categoryRVAdaptor);

         GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
         wallpaperRV.setLayoutManager(gridLayoutManager);
         wallpaperAdaptor=new WallpaperAdaptor(wallpaperArrayList,this);
         wallpaperRV.setAdapter(wallpaperAdaptor);

         getCategories();
         getWallpapers();

         searchIV.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String searchStr= searchEdt.getText().toString();
                 if(searchStr.isEmpty()){
                     Toast.makeText(MainActivity.this,"Please enter your search querry",Toast.LENGTH_SHORT).show();
                 }else{
                     getWallpapersByCategory(searchStr);
                 }
             }
         });
    }

    private void getWallpapersByCategory(String category){

    }
    private void getCategories(){
         categoryRVModelArrayList.add(new CategoryRVModel("Technology","https://images.unsplash.com/photo-1488590528505-98d2b5aba04b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwxfDB8MXxhbGx8fHx8fHx8fA&ixlib=rb-1.2.1&q=80&w=1080&utm_source=unsplash_source&utm_medium=referral&utm_campaign=api-credit"));
        categoryRVModelArrayList.add(new CategoryRVModel("Nature","https://images.unsplash.com/photo-1426604966848-d7adac402bff?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwxfDB8MXxhbGx8fHx8fHx8fA&ixlib=rb-1.2.1&q=80&w=1080&utm_source=unsplash_source&utm_medium=referral&utm_campaign=api-credit"));
//        categoryRVModelArrayList.add(new CategoryRVModel("Ocean",);
//        categoryRVModelArrayList.add(new CategoryRVModel("Cat",);
     }
    private void getWallpapers(){

    }

    @Override
    public void onCategoryClick(int position) {
        String category = categoryRVModelArrayList.get(position).getCategory();
        getWallpapersByCategory(category);
    }
}