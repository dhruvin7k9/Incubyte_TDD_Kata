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
            String[] numbersArray = numbers.split(",");
            int sum = 0;
            for (String number : numbersArray) 
            {
                sum += Integer.parseInt(number);
            }
            return sum;
        }
    }
}