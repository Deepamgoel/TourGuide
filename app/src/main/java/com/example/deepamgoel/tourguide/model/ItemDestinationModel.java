package com.example.deepamgoel.tourguide.model;

public class ItemDestinationModel {

    private String imageUrl;
    private String title;
    private String descriptionShort;
    private String descriptionLong;
    private float rating;

    public ItemDestinationModel(String imageUrl, String title, String descriptionShort, String descriptionLong, float rating) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.descriptionShort = descriptionShort;
        this.descriptionLong = descriptionLong;
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public float getRating() {
        return rating;
    }
}
