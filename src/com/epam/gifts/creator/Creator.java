package com.epam.gifts.creator;

import com.epam.gifts.entity.ChocolateCandy;
import com.epam.gifts.entity.Lollipop;
import com.epam.gifts.entity.Chocolate;
import com.epam.gifts.entity.Sweets;
import com.epam.gifts.exception.IncorrectParameterException;
import com.epam.gifts.service.ReadFileService;
import com.epam.gifts.enums.Taste;
import com.epam.gifts.validator.DataChecker;
import com.epam.gifts.entity.Zephyr;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.FileNotFoundException;
import java.util.StringTokenizer;

public class Creator {

    static {
        new DOMConfigurator().doConfigure("resources/log4j.xml", LogManager.getLoggerRepository());
    }

    static Logger logger = Logger.getLogger(Creator.class);

    private ReadFileService readFileService;
    private DataChecker dataChecker;

    public Creator() throws FileNotFoundException {
        readFileService = new ReadFileService();
        dataChecker = new DataChecker();
    }

    public Sweets createSweets() throws IncorrectParameterException{
        String lineFromFile = readFileService.takeLineFromFile();
        int typeSweets = dataChecker.checkSweets(lineFromFile);
        Sweets sweets;
        if (typeSweets == -1) {
            throw new IncorrectParameterException("A mistake in data from file");
        } else {
            switch (typeSweets) {
                case 0:
                    sweets = createChocolateCandy(lineFromFile);
                    break;
                case 1:
                    sweets = createLollipop(lineFromFile);
                    break;
                case 2:
                    sweets = createZephyr(lineFromFile);
                    break;
                case 3:
                    sweets = createChocolate(lineFromFile);
                    break;
                default:
                    throw new IncorrectParameterException("A mistake in data from file");
            }
        }
        return sweets;
    }

    public ChocolateCandy createChocolateCandy(String lineFromFile) {
        StringTokenizer st = new StringTokenizer(lineFromFile);
        st.nextToken();
        int weight = Integer.parseInt(st.nextToken());
        int sugarPercentage = Integer.parseInt(st.nextToken());
        boolean filled = (Integer.parseInt(st.nextToken()) == 1);
        boolean glaze = (Integer.parseInt(st.nextToken()) == 1);
        return new ChocolateCandy(weight, sugarPercentage, filled, glaze);
    }

    public Lollipop createLollipop(String lineFromFile) {
        StringTokenizer st = new StringTokenizer(lineFromFile);
        st.nextToken();
        int weight = Integer.parseInt(st.nextToken());
        int sugarPercentage = Integer.parseInt(st.nextToken());
        boolean filled = (Integer.parseInt(st.nextToken()) == 1);
        Taste taste = converterTaste(st.nextToken());
        return new Lollipop(weight, sugarPercentage, filled, taste);
    }

    public Zephyr createZephyr(String lineFromFile) {
        StringTokenizer st = new StringTokenizer(lineFromFile);
        st.nextToken();
        int weight = Integer.parseInt(st.nextToken());
        int sugarPercentage = Integer.parseInt(st.nextToken());
        boolean glaze = (Integer.parseInt(st.nextToken()) == 1);
        Taste taste = converterTaste(st.nextToken());
        return new Zephyr(weight, sugarPercentage, glaze, taste);
    }

    public Chocolate createChocolate(String lineFromFile) {
        StringTokenizer st = new StringTokenizer(lineFromFile);
        st.nextToken();
        int weight = Integer.parseInt(st.nextToken());
        int sugarPercentage = Integer.parseInt(st.nextToken());
        int cocoaPercentage = Integer.parseInt(st.nextToken());
        boolean filled = (Integer.parseInt(st.nextToken()) == 1);
        return new Chocolate(weight, sugarPercentage, cocoaPercentage, filled);
    }

    public Taste converterTaste(String symbol) {
        switch (symbol) {
            case "O":
                return Taste.ORANGE;
            case "L":
                return Taste.LEMON;
            case "A":
                return Taste.APPLE;
            case "V":
                return Taste.VANILLA;
            case "M":
                return Taste.MINT;
            case "C":
                return Taste.COCONUT;
            case "N":
                return Taste.NUT;
            default:
                return null;
        }
    }

    public ReadFileService getReadFileService() {
        return readFileService;
    }

    public DataChecker getDataChecker() {
        return dataChecker;
    }

    public void closeFile() {
        readFileService.closeReader();
    }
}
