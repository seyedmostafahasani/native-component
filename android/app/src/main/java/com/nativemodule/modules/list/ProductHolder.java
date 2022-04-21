package com.nativemodule.modules.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nativemodule.R;

import me.relex.photodraweeview.PhotoDraweeView;

public class ProductHolder extends RecyclerView.ViewHolder {
    PhotoDraweeView avatar, imageProduct;
    TextView title, description;
    public ProductHolder(@NonNull View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        imageProduct = itemView.findViewById(R.id.imageProduct);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
    }
}
