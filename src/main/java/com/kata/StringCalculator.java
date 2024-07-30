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
            String delimiter = "[,|\n]";
            // check if the string starts with a custom delimiter
            if (numbers.startsWith("//")) 
            {
                int indexOfNewLine = numbers.indexOf("\n");
                delimiter = numbers.substring(2, indexOfNewLine);
                numbers = numbers.substring(indexOfNewLine + 1);
            }
            String[] numbersArray = numbers.split(delimiter);
            int sum = 0;
            for (String number : numbersArray) 
            {
                sum += Integer.parseInt(number);
            }
            return sum;
        }
    }
}