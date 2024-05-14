package com.example.myapplication.slot31;

public class ProductSlot31 {
    private String styleId;
    private String brand;
    private String price;
    private String additionalInfo;
    private String searchImage; // URL của hình ảnh

    public ProductSlot31(String styleId, String brand, String price, String additionalInfo, String searchImage) {
        this.styleId = styleId;
        this.brand = brand;
        this.price = price;
        this.additionalInfo = additionalInfo;
        this.searchImage = searchImage;
    }

    // Getters và Setters cho các trường dữ liệu

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getSearchImage() {
        return searchImage;
    }

    public void setSearchImage(String searchImage) {
        this.searchImage = searchImage;
    }
}

