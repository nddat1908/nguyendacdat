package com.learndemo.nguyendacdat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.learndemo.nguyendacdat.R;
import com.learndemo.nguyendacdat.adapter.ProductAdapter;
import com.learndemo.nguyendacdat.database.AppDatabase;
import com.learndemo.nguyendacdat.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class ActivityListProduct extends AppCompatActivity {

    AppDatabase db;
    List<ProductEntity> listProduct = new ArrayList<>();
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        db = AppDatabase.getAppDatabase(this);
        listProduct = db.productDao().getAllProduct();


        adapter = new ProductAdapter(this,listProduct);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        RecyclerView rvUser = findViewById(R.id.rvProduct);
        rvUser.setLayoutManager(layoutManager);
        rvUser.setAdapter(adapter);
    }
}