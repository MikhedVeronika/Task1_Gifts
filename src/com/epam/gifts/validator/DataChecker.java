package com.epam.gifts.validator;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class DataChecker {

    private Pattern patternWeight = Pattern.compile("[1-9][0-9]*");
    private Pattern patternPercentage = Pattern.compile("[1-9][0-9]?");
    private Pattern patternBoolean = Pattern.compile("[01]");
    private Pattern patternTaste = Pattern.compile("[OLAVMCN]");

    public DataChecker() {
    }

    public int checkSweets(String lineFromFile) {

        lineFromFile = lineFromFile.trim();
        StringTokenizer stringTokenizer = new StringTokenizer(lineFromFile);

        String typeSweets = stringTokenizer.nextToken();
        int index = -1;
        switch (typeSweets) {
            case "s":
                if (checkChocolateCandy(stringTokenizer)) {
                    index = 0;
                }
                break;
            case "l":
                if (checkLollipop(stringTokenizer)) {
                    index = 1;
                }
                break;
            case "z":
                if (checkZephyr(stringTokenizer)) {
                    index = 2;
                }
                break;
            case "c":
                if (checkChocolate(stringTokenizer)) {
                    index = 3;
                }
                break;
            default:
                index = -1;
        }
        return index;
    }

    public boolean checkChocolateCandy(StringTokenizer st) {

        if (patternWeight.matcher(st.nextToken()).matches() && patternPercentage.matcher(st.nextToken()).matches()
                && patternBoolean.matcher(st.nextToken()).matches() && patternBoolean.matcher(st.nextToken()).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkLollipop(StringTokenizer st) {
        if (patternWeight.matcher(st.nextToken()).matches() && patternPercentage.matcher(st.nextToken()).matches()
                && patternBoolean.matcher(st.nextToken()).matches() && patternTaste.matcher(st.nextToken()).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkZephyr(StringTokenizer st) {
        if (patternWeight.matcher(st.nextToken()).matches() && patternPercentage.matcher(st.nextToken()).matches()
                && patternBoolean.matcher(st.nextToken()).matches() && patternTaste.matcher(st.nextToken()).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkChocolate(StringTokenizer st) {
        if (patternWeight.matcher(st.nextToken()).matches() && patternPercentage.matcher(st.nextToken()).matches()
                && patternPercentage.matcher(st.nextToken()).matches() && patternBoolean.matcher(st.nextToken()).matches()) {
            return true;
        } else {
            return false;
        }
    }
}
