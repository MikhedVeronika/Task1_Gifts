package com.epam.gifts.entity;

import com.epam.gifts.enums.Taste;

public class Lollipop extends Candy {

    private Taste taste;

    public Lollipop() {

    }

    public Lollipop(int weight, int sugarPercentage, boolean filled, Taste taste) {
        super(weight, sugarPercentage, filled);
        this.taste = taste;
    }

    public Taste getTaste() {
        return taste;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "Lollipop [weight = " + getWeight() + ", sugarPercentage = " + getSugarPercentage() +
                ", filled = " + Boolean.toString(isFilled()) + ", taste = " + getTaste() + "]";
    }
}
