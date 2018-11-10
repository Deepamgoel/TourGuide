package com.example.deepamgoel.tourguide.model;

public class ItemEatModel {
    private String imageUrl;
    private String title;
    private String restaurant;
    private String description;
    private String price;
    private String where;
    private String timing;

    public ItemEatModel(String imageUrl, String title, String restaurant, String description, String price, String where, String timing) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.restaurant = restaurant;
        this.description = description;
        this.price = price;
        this.where = where;
        this.timing = timing;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getWhere() {
        return where;
    }

    public String getTiming() {
        return timing;
    }
}
