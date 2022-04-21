package com.nativemodule.modules.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.gson.Gson;
import com.nativemodule.R;

import java.util.Arrays;

public class ListView extends LinearLayout {
    CustomRecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerViewAdapter adapter;
    Product[] products;

    public ListView(Context context) {
        super(context);
        inflate(context, R.layout.list, this);
        recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        swipeRefreshLayout = findViewById(R.id.refresh_layout);
        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(@Nullable ReadableArray data) {
        post(() -> {
            Gson gson = new Gson();
            assert data != null;
            products = gson.fromJson(data.toString(), Product[].class);
            adapter.clearProducts();
            adapter.addProducts(Arrays.asList(products));
            adapter.notifyDataSetChanged();
        });
    }

    public void setRefreshing(@NonNull Boolean refreshFeed) {
        post(() -> {
            swipeRefreshLayout.setOnRefreshListener(this::refreshFeed);
            swipeRefreshLayout.setRefreshing(refreshFeed);
        });
    }

    public void refreshFeed() {
        WritableMap map = Arguments.createMap();
        try {
            ReactContext reactContext = (ReactContext) getContext();
            reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                    .emit("refreshFeed", map);
        } catch (Exception e) {
            Log.e("ReactNative", "Caught Exception: " + e.getMessage());
        }
    }
}
