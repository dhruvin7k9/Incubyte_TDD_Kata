package com.kata;

public class StringCalculator 
{
    public int add(String numbers) 
    {
        if (numbers.isEmpty()) 
        {
            return 0;
        } 
        else 
        {
            // regex to split the string
            String delimiter = "[,";
            // check if the string starts with a custom delimiter
            if (numbers.startsWith("//")) 
            {
                int indexOfNewLine = numbers.indexOf("\n");
                // get the custom delimiter, //[ -> delimiter = [ as [ is special character in regex
                String[] delimiterStrings = numbers.substring(2, indexOfNewLine).split("\\[|\\]");
                for (String s : delimiterStrings) 
                {
                    if (!s.isEmpty())
                        delimiter += "|" + s;
                }

                numbers = numbers.substring(indexOfNewLine + 1);
            }
            delimiter += "|\n]";

            // processing the numbers with filtered input string
            String[] numbersArray = numbers.split(delimiter);
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