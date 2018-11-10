package com.example.deepamgoel.tourguide.model;

public class ItemModel {

    private String imageUrl;
    private String title;
    private String description;
    private float rating;

    public ItemModel(String imageUrl, String title, String description, float rating) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public float getRating() {
        return rating;
    }
}
