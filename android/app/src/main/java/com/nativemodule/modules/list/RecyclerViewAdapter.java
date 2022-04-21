package com.nativemodule.modules.list;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nativemodule.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    List<Product> products = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder vh;
        View view = inflater.inflate(R.layout.list_items, parent, false);
        vh = new ProductHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Product product = products.get(position);

        if (holder instanceof ProductHolder){
            ((ProductHolder) holder).avatar.setImageURI(parser(product.getThumbnail()));
            ((ProductHolder) holder).title.setText(product.getTitle());
            ((ProductHolder) holder).imageProduct.setImageURI(parser(product.getThumbnail()));
            ((ProductHolder) holder).description.setText(product.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void clearProducts(){
        products.clear();
    }

    public void addProducts(List<Product> products){
        this.products.addAll(products);
    }

    public Uri parser(String url){
        return Uri.parse(url);
    }
}
