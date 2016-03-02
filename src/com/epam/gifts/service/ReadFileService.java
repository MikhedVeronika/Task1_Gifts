package com.epam.gifts.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.*;

public class ReadFileService {

    static {
        new DOMConfigurator().doConfigure("resources/log4j.xml", LogManager.getLoggerRepository());
    }
    static Logger logger = Logger.getLogger(ReadFileService.class);

    private BufferedReader bufferedReader;
    private String filepath = "input/sweets.txt";

    public ReadFileService() throws FileNotFoundException{
        bufferedReader = new BufferedReader(new FileReader(filepath));
    }

    public boolean hasNextData() {
        try {
            return bufferedReader.ready();
        } catch (IOException e) {
            return false;
        }
    }

    public String takeLineFromFile() {
        try {
            return bufferedReader.readLine();
        }
        catch (IOException e) {
            return new String("");
        }
    }

    public void closeReader() {
        try {
            bufferedReader.close();
        }
        catch (IOException e) {
            logger.error("Can not close file");
        }
    }


}
