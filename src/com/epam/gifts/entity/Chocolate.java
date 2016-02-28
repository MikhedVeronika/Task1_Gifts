package com.epam.gifts.entity;

import com.epam.gifts.entity.Sweets;

public class Chocolate extends Sweets {

    private int cocoaPercentage;
    private boolean filled;

    public Chocolate() {

    }

    public Chocolate(int weight, int sugarPercentage, int cocoaPercentage, boolean filled) {
        super(weight, sugarPercentage);
        this.cocoaPercentage = cocoaPercentage;
        this.filled = filled;
    }

    public int getCocoaPercentage() {
        return cocoaPercentage;
    }

    public void setCocoaPercentage(int cocoaPercentage) {
        this.cocoaPercentage = cocoaPercentage;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Chocolate [weight = " + getWeight() + ", sugarPercentage = " + getSugarPercentage() +
                ", cocoaPercentage = " + getCocoaPercentage() + ", filled = " + Boolean.toString(isFilled()) + "]";
    }
}
