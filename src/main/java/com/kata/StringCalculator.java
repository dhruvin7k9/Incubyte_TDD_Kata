package com.kata;

import java.util.ArrayList;
import java.util.HashSet;

public class StringCalculator {
    private String findDelimiters(String numbers) {
        String delimiter = "[,";
        if (numbers.startsWith("//")) {
            int indexOfNewLine = numbers.indexOf("\n");
            String[] delimiterStrings = numbers.substring(2, indexOfNewLine).split("\\[|\\]");
            for (String s : delimiterStrings) {
                if (!s.isEmpty())
                    delimiter += "|" + s;
            }
        }
        delimiter += "|\n]";

        return delimiter;
    }

    private String[] filterNumberString(String numbers, String delimiters) {
        String[] numberStringTokens = {};

        if (numbers.startsWith("//")) {
            int indexOfNewLine = numbers.indexOf("\n");
            numbers = numbers.substring(indexOfNewLine + 1);
        }
        numberStringTokens = numbers.split(delimiters);
        return numberStringTokens;
    }

    private ArrayList<Integer> parseIntFromStringTokens(String[] numberStringTokens) {
        ArrayList<Integer> numbersArray = new ArrayList<Integer>();

        for (int i = 0; i < numberStringTokens.length; i++) {
            if (numberStringTokens[i].isEmpty())
                continue;

            int number = Integer.parseInt(numberStringTokens[i]);
            numbersArray.add(number);
        }

        return numbersArray;
    }

    private void checkForNegativeNumbers(ArrayList<Integer> numbersArray) {
        String negativeNumbers = "";
        for (int number : numbersArray) {
            if (number < 0) {
                negativeNumbers += number + ",";
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(
                    "Negatives not allowed: [" + negativeNumbers.substring(0, negativeNumbers.length() - 1) + "]");
        }
    }

    private ArrayList<Integer> ignoreNumGreaterThan1000(ArrayList<Integer> numbersArray) {
        ArrayList<Integer> numGreaterThan1000 = new ArrayList<Integer>();
        for (int number : numbersArray) {
            if (number <= 1000) {
                numGreaterThan1000.add(number);
            }
        }
        return numGreaterThan1000;
    }

    private ArrayList<Integer> ignoreDuplicateNums(ArrayList<Integer> numbersArray) {
        ArrayList<Integer> uniqueNumsArray = new ArrayList<Integer>();
        HashSet<Integer> uniqueNumsSet = new HashSet<>();
        uniqueNumsSet.addAll(numbersArray);

        uniqueNumsArray.addAll(uniqueNumsSet);
        return uniqueNumsArray;
    }

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String delimiters = findDelimiters(numbers);
            String[] numberStringTokens = filterNumberString(numbers, delimiters);
            ArrayList<Integer> numbersArray = parseIntFromStringTokens(numberStringTokens);
            checkForNegativeNumbers(numbersArray);

            int sum = 0;

            numbersArray = ignoreNumGreaterThan1000(numbersArray);
            numbersArray = ignoreDuplicateNums(numbersArray);
            for (int number : numbersArray) {
                sum += number;
            }

            return sum;
        }
    }
}