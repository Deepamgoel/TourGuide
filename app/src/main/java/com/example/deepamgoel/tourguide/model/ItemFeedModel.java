package com.example.deepamgoel.tourguide.model;

public class ItemFeedModel {
    private String linkUrl;
    private String imageUrl;
    private String title;
    private String description;
    private String author;

    public ItemFeedModel(String linkUrl, String imageUrl, String title, String description, String author) {
        this.linkUrl = linkUrl;
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public String getLinkUrl() {
        return linkUrl;
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

    public String getAuthor() {
        return author;
    }
}
