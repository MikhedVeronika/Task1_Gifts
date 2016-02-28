package com.epam.gifts.comparator;

import com.epam.gifts.entity.Sweets;

import java.util.Comparator;

public class WeightComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return (((Sweets) o1).getWeight() - ((Sweets) o2).getWeight());
    }
}
