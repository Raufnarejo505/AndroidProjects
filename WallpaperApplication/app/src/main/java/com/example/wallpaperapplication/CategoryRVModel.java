package com.example.wallpaperapplication;

public class CategoryRVModel {
    private String category;
    private String getCategoryIVURl;

    public CategoryRVModel(String category, String getCategoryIVURl) {
        this.category = category;
        this.getCategoryIVURl = getCategoryIVURl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGetCategoryIVURl() {
        return getCategoryIVURl;
    }

    public void setGetCategoryIVURl(String getCategoryIVURl) {
        this.getCategoryIVURl = getCategoryIVURl;
    }
}
