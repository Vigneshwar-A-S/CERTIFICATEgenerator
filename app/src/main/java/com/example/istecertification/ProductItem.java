package com.example.istecertification;

public class ProductItem {

    private String fruits = "";
    private String quantity = "";

    public ProductItem(String fruits, String quantity) {
        this.fruits = fruits;
        this.quantity = quantity;
    }

    //firebase needs empty constructor, so create it


    public ProductItem() {
    }

    //Getting and Setting Values


    public String getFruits() {
        return fruits;
    }

    public void setFruits(String fruits) {
        this.fruits = fruits;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
