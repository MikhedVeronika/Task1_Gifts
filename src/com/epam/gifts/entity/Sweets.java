package com.epam.gifts.entity;

public abstract class Sweets {

    private int weight;
    private int sugarPercentage;

    public Sweets() {
    }

    public Sweets(int weight, int sugarPercentage) {
        this.weight = weight;
        this.sugarPercentage = sugarPercentage;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSugarPercentage() {
        return sugarPercentage;
    }

    public void setSugarPercentage(int sugarPercentage) {
        this.sugarPercentage = sugarPercentage;
    }

}
