package com.kata;

public class StringCalculator 
{
    private String findDelimiters(String numbers) {
        String delimiter = "[,";
        if (numbers.startsWith("//")) 
        {
            int indexOfNewLine = numbers.indexOf("\n");
            String[] delimiterStrings = numbers.substring(2, indexOfNewLine).split("\\[|\\]");
            for (String s : delimiterStrings) 
            {
                if (!s.isEmpty())
                    delimiter += "|" + s;
            }
        }
        delimiter += "|\n]";

        return delimiter;
    }

    private String[] filterNumberString (String numbers, String delimiters) {
        String[] numberStringTokens = {};

        if (numbers.startsWith("//")) 
        {
            int indexOfNewLine = numbers.indexOf("\n");
            numbers = numbers.substring(indexOfNewLine +1);
        }
        numberStringTokens = numbers.split(delimiters);
        return numberStringTokens;
    }

    public int add(String numbers) 
    {
        if (numbers.isEmpty()) 
        {
            return 0;
        } 
        else 
        {
            String delimiters = findDelimiters(numbers);
            String[] numbersArray = filterNumberString(numbers, delimiters);
            

            int sum = 0, i;
            String negativeNumbers = "";
            for (i = 0; i < numbersArray.length; i++) 
            {
                if (numbersArray[i].isEmpty())
                    continue;
                
                int number = Integer.parseInt(numbersArray[i]);
                if (number < 0) {
                    negativeNumbers += number + ",";
                }
                else if (number <= 1000){
                    sum += number;
                }
            }
            
            if (!negativeNumbers.isEmpty()) 
            {
                throw new IllegalArgumentException("Negatives not allowed: [" + negativeNumbers.substring(0, negativeNumbers.length() - 1) + "]");
            }
            return sum;
        }
    }
}