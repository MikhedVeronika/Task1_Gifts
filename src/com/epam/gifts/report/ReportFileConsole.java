package com.epam.gifts.report;

import com.epam.gifts.entity.Sweets;
import com.epam.gifts.gift.Gift;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReportFileConsole {

    static {
        new DOMConfigurator().doConfigure("resources/log4j.xml", LogManager.getLoggerRepository());
    }

    static Logger logger = Logger.getLogger(Gift.class);
    private String filepath = "output/output.txt";
    private FileWriter fw;

    public ReportFileConsole() {
        try {
            fw = new FileWriter(filepath);
        } catch (IOException e) {
            logger.error("Can not open file 'output.txt' to write");
        }
    }

    public void printAllSweets(Gift gift) {
        System.out.println("All sweets:");
        for (int i = 0; i < gift.getSweets().size(); i++) {
            System.out.println(gift.getSweets().get(i));
        }
    }

    public void writeAllSweetsInFile(Gift gift) {
        try {
            fw.write("All sweets:" + "\r\n");
            for (int i = 0; i < gift.getSweets().size(); i++) {
                fw.write(gift.getSweets().get(i).toString() + "\r\n");
            }
        } catch (IOException e) {
            logger.error("Can not write data to file");
        }
    }

    public void printListSweets(ArrayList<Sweets> sweets, int spMin, int spMax) {
        System.out.println("Sweets with sugar percentage from " + spMin + " to " + spMax);
        for (int i = 0; i < sweets.size(); i++) {
            System.out.println(sweets.get(i));
        }
    }

    public void writeListSweetsInFile(ArrayList<Sweets> sweets, int spMin, int spMax) {
        try {
            fw.write("Sweets with sugar percentage from " + spMin + " to " + spMax + "\r\n");
            for (int i = 0; i < sweets.size(); i++) {
                fw.write(sweets.get(i).toString() + "\r\n");
            }
        } catch (IOException e) {
            logger.error("Can not write data to file");
        }
    }

    public void printTotalWeight(Gift gift) {
        System.out.println("Total weight of gift: " + gift.getTotalWeight());
    }

    public void writeTotalWeightInFile(Gift gift) {
        try {
            fw.write("Total weight of gift: " + gift.getTotalWeight() + "\r\n");
        } catch (IOException e) {
            logger.error("Can not write data to file");
        }
    }

    public void printString (String str) {
        System.out.println(str);
        try {
            fw.write(str+"\r\n");
        }catch (IOException e) {
            logger.error("Can not write string to file");
        }
    }

    public void closeOutput() {
        try {
            fw.close();
        } catch (IOException e) {
            logger.error("Can not close file 'output.txt' ");
        }
    }

}
