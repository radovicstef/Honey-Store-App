package com.example.login;

public class Narudzbina {

    public Product product;
    public int numberOrdered;
    public int overallPrice;

    public Narudzbina(Product product, int numberOrdered, int overallPrice) {
        this.product = product;
        this.numberOrdered = numberOrdered;
        this.overallPrice = overallPrice;
    }

    public int getOverallPrice() {
        return overallPrice;
    }

    public void setOverallPrice(int overallPrice) {
        this.overallPrice = overallPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumberOrdered() {
        return numberOrdered;
    }

    public void setNumberOrdered(int numberOrdered) {
        this.numberOrdered = numberOrdered;
    }
}
