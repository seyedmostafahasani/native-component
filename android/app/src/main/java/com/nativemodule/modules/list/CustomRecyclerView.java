package com.nativemodule.modules.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerView extends RecyclerView {
    private boolean isRequestLayoutCalled = false;

    public CustomRecyclerView(@NonNull Context context) {
        super(context);
    }

    public CustomRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @SuppressLint("WrongCall")
    @Override
    public void requestLayout() {
        super.requestLayout();
        if(!isRequestLayoutCalled){
            isRequestLayoutCalled = true;
            this.post(() -> {
                isRequestLayoutCalled = false;
                layout(getLeft(), getTop(), getRight(), getBottom());
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
            });
        }
    }
}
