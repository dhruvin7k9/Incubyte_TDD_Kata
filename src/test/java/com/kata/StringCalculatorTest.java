package com.kata;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest 
{
    @Test
    public void testEmptyString()
    {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals( 0,  stringCalculator.add(""));
    }

    @Test
    public void testSingleNumber()
    {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals( 1,  stringCalculator.add("1"));
    }
}