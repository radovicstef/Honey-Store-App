package com.example.login;

public class Product {

    public String productName;
    public String price;
    public String seller;
    public String imagePath;
    public String description;
    public String usage;

    public Product(String productName, String price, String buyer, String imagePath){
        this.productName = productName;
        this.price = price;
        this.seller = buyer;
        this.imagePath = imagePath;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBuyer() {
        return seller;
    }

    public void setBuyer(String buyer) {
        this.seller = buyer;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
}
