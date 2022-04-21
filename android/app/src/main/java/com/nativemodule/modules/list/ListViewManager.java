package com.nativemodule.modules.list;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ListViewManager extends SimpleViewManager<ListView> {
    private final String REACT_CLASS = "nativeList";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected ListView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new ListView(reactContext);
    }

    @ReactProp(name = "data")
    public void setData(ListView view, ReadableArray data) {
        view.setData(data);
    }

    @ReactProp(name = "refreshing")
    public void setRefreshing(ListView view, boolean refreshing) {
        view.setRefreshing(refreshing);
    }
}
