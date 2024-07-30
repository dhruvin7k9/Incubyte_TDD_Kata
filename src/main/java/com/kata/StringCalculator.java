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
            String delimiter = "[,|\n]";
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