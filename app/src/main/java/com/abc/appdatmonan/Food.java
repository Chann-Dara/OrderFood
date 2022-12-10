package com.abc.appdatmonan;

public class Food {
    private String foodTitle, foodPrice, foodCode;

    public Food(){}

    public Food(String foodTitle, String foodPrice, String foodCode) {
        this.foodTitle = foodTitle;
        this.foodPrice = foodPrice;
        this.foodCode = foodCode;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        this.foodTitle = foodTitle;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }
}
