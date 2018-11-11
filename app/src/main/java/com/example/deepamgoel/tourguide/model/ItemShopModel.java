package com.example.deepamgoel.tourguide.model;

public class ItemShopModel {
    private String imageUrl;
    private String title;
    private String descriptionShort;
    private String descriptionLong;

    public ItemShopModel(String imageUrl, String title, String descriptionShort, String descriptionLong) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.descriptionShort = descriptionShort;
        this.descriptionLong = descriptionLong;
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
}
