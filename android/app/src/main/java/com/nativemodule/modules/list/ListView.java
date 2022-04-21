package com.nativemodule.modules.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.facebook.react.bridge.ReadableArray;
import com.google.gson.Gson;
import com.nativemodule.R;

import java.util.Arrays;

public class ListView extends LinearLayout {
    CustomRecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    Product[] products;

    public ListView(Context context) {
        super(context);
        inflate(context, R.layout.list, this);
        recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(@Nullable ReadableArray data){
    post(() -> {
        Gson gson = new Gson();
        assert data != null;
        products = gson.fromJson(data.toString(), Product[].class);
        adapter.clearProducts();
        adapter.addProducts(Arrays.asList(products));
        adapter.notifyDataSetChanged();
    });
    }
}
