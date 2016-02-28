package com.epam.gifts.gift;

import com.epam.gifts.comparator.SugarPercentageComparator;
import com.epam.gifts.comparator.WeightComparator;
import com.epam.gifts.creator.Creator;
import com.epam.gifts.entity.Sweets;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Gift {
    static {
        new DOMConfigurator().doConfigure("resources/log4j.xml", LogManager.getLoggerRepository());
    }

    static Logger logger = Logger.getLogger(Gift.class);

    private int totalWeight;
    private ArrayList<Sweets> sweets;

    public Gift() {
        sweets = new ArrayList<Sweets>();
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public ArrayList<Sweets> getSweets() {
        return new ArrayList<Sweets>(sweets);
    }

    public void addElement(Sweets element) {
        if (element != null) {
            sweets.add(element);
            logger.info("Object " + element.toString() + " was added to gift");
            this.totalWeight += element.getWeight();
        } else {
            logger.error("Object didn't created");
        }
    }

    public void fillGift() throws FileNotFoundException {
        Creator creator = new Creator();
        while (creator.getReadFileService().hasNextData()) {
            this.addElement(creator.createSweets());
        }
        creator.closeFile();
    }

    public ArrayList<Sweets> takeSweetsBySugar(int spMin, int spMax) {
        ArrayList<Sweets> sweetSugar = new ArrayList<Sweets>();
        for (int i = 0; i < sweets.size(); i++) {
            if (sweets.get(i).getSugarPercentage() >= spMin && sweets.get(i).getSugarPercentage() <= spMax) {
                sweetSugar.add(sweets.get(i));
            }
        }
        return sweetSugar;
    }

    public void sortSweetsByWeight() {
        logger.info("Sorting sweets by it's weight");
        Collections.sort(this.sweets, new WeightComparator());
    }

    public void sortSweetsBySugarPercentage() {
        logger.info("Sorting sweets by sugar percentage");
        Collections.sort(this.sweets, new SugarPercentageComparator());
    }
}
