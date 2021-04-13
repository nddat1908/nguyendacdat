package com.learndemo.nguyendacdat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.learndemo.nguyendacdat.activity.ActivityListProduct;
import com.learndemo.nguyendacdat.database.AppDatabase;
import com.learndemo.nguyendacdat.entity.ProductEntity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edEnterName,edEnterQuantity;
    Button btAdd,btView;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void initView(){
        edEnterName = findViewById(R.id.edEnterName);
        edEnterQuantity = findViewById(R.id.edEnterQuantity);

        btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(this);
        btView = findViewById(R.id.btView);
        btView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btAdd){
            onAdd();
        }
        if (v == btView){
            onView();
        }
    }

    private void onAdd() {
        if (edEnterName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter name", Toast.LENGTH_LONG).show();
            return;
        }
        if (edEnterQuantity.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter quantity", Toast.LENGTH_LONG).show();
            return;
        }

    }

    private void onView(){
        insertProduct();
        Intent intent = new Intent(MainActivity.this, ActivityListProduct.class);
        startActivity(intent);
    }

    private void insertProduct(){
        ProductEntity pe = new ProductEntity();
        pe.Name = edEnterName.getText().toString();
        pe.Quantity = Integer.valueOf(edEnterQuantity.getText().toString());
        db.productDao().insertProduct(pe);
        Toast.makeText(this, "Add product successfully", Toast.LENGTH_SHORT).show();

    }
}