package com.epam.gifts.main;

import com.epam.gifts.gift.Gift;
import com.epam.gifts.report.ReportFileConsole;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.FileNotFoundException;

public class Main {

    static {
        new DOMConfigurator().doConfigure("resources/log4j.xml", LogManager.getLoggerRepository());
    }

    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        ReportFileConsole rfc = new ReportFileConsole();
        logger.info("Start creating gift");

        Gift gift = new Gift();
        try {
            gift.fillGift();
        } catch (FileNotFoundException e) {
            logger.error("Can not open file 'sweets.txt' to read");
        }

        rfc.printAllSweets(gift);
        rfc.writeAllSweetsInFile(gift);

        gift.sortSweetsByWeight();
        rfc.printAllSweets(gift);
        rfc.writeAllSweetsInFile(gift);

        gift.sortSweetsBySugarPercentage();
        rfc.printAllSweets(gift);
        rfc.writeAllSweetsInFile(gift);

        int spMin = 55;
        int spMax = 70;
        rfc.printListSweets(gift.takeSweetsBySugar(spMin, spMax), spMin, spMax);
        rfc.writeListSweetsInFile(gift.takeSweetsBySugar(spMin, spMax), spMin, spMax);

        rfc.printTotalWeight(gift);
        rfc.writeTotalWeightInFile(gift);

        rfc.closeOutput();
    }
}
