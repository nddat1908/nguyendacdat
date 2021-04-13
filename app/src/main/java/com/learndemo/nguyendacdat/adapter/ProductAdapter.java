package com.learndemo.nguyendacdat.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learndemo.nguyendacdat.R;
import com.learndemo.nguyendacdat.entity.ProductEntity;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {

    Activity activity;
    List<ProductEntity> listProduct;

    public ProductAdapter(Activity activity, List<ProductEntity> listProduct) {
        this.activity = activity;
        this.listProduct = listProduct;
    }

//    public void ReloadData(List<ProductEntity> list){
//        this.listProduct = list;
//        this.notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = activity.getLayoutInflater().inflate(R.layout.item_product,parent,false);
        ProductViewHolder holder =  new ProductViewHolder(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductViewHolder productHolder = (ProductViewHolder) holder;
        ProductEntity pe = listProduct.get(position);
        productHolder.tvId.setText(String.valueOf(pe.Id));
        productHolder.tvName.setText(pe.Name);
        productHolder.tvQuantity.setText(String.valueOf(pe.Quantity));
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvQuantity;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
        }
    }
}
