package com.nativemodule.modules.list;

import java.util.List;

public class Product {
    private int id;
    private String title;
    private String description;
    private float price;
    private String thumbnail;
    private List<String> images;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
