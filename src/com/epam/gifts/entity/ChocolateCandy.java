package com.epam.gifts.entity;

import com.epam.gifts.entity.Candy;

public class ChocolateCandy extends Candy {

    private boolean glaze;

    public ChocolateCandy() {

    }

    public ChocolateCandy(int weight, int sugarPercentage, boolean filled, boolean glaze) {
        super(weight, sugarPercentage, filled);
        this.glaze = glaze;
    }

    public boolean isGlaze() {
        return glaze;
    }

    public void setGlaze(boolean glaze) {
        this.glaze = glaze;
    }

    @Override
    public String toString() {
        return "ChocolateCandy [weight = " + getWeight() + ", sugarPercentage = " + getSugarPercentage() +
                ", filled = " + Boolean.toString(isFilled()) + ", glaze = " + Boolean.toString(isGlaze()) + "]";
    }

}
