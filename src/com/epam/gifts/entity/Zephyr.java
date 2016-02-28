package com.epam.gifts.entity;

import com.epam.gifts.entity.Sweets;
import com.epam.gifts.taste.Taste;

public class Zephyr extends Sweets {

    private boolean glaze;
    private Taste taste;

    public Zephyr(int weight, int sugarPercentage, boolean glaze, Taste taste) {
        super(weight, sugarPercentage);
        this.glaze = glaze;
        this.taste = taste;
    }

    public boolean isGlaze() {
        return glaze;
    }

    public void setGlaze(boolean glaze) {
        this.glaze = glaze;
    }

    public Taste getTaste() {
        return taste;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "Zephyr [weight = " + getWeight() + ", sugarPercentage = " + getSugarPercentage() +
                ", glaze = " + Boolean.toString(isGlaze()) + ", taste = " + getTaste() + "]";
    }

}
