package com.example.studirep;

public class foodItem {
    private String foodName;
    private String foodType;
    private int foodWeight;
    public foodItem(String firstLine, int secondLine ,String thirdLine) {
        foodName = firstLine;
        foodWeight = secondLine;
        foodType = thirdLine;
    }
    public String getFoodName() {
        return foodName;
    }
    public int getFoodWeight() {
        return foodWeight;
    }

    public String getFoodType() {
        return foodType;
    }
}

