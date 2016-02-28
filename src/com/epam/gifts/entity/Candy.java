package com.epam.gifts.entity;

import com.epam.gifts.entity.Sweets;

public abstract class Candy extends Sweets {

    private boolean filled;

    public Candy() {
    }

    public Candy(int weight, int sugarPercentage, boolean filled) {
        super(weight, sugarPercentage);
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
