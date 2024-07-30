package com.kata;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class StringCalculatorTest 
{
    static StringCalculator stringCalculator;

    @BeforeClass
    public static void setStringCalculator() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void testEmptyString()
    {
        assertEquals( 0,  stringCalculator.add(""));
    }

    @Test
    public void testSingleNumber()
    {
        assertEquals( 1,  stringCalculator.add("1"));
    }

    @Test
    public void testCommaSeparatedNumbers()
    {
        assertEquals( 13,  stringCalculator.add("1,2,10"));
    }

    @Test
    public void testNewLineAndCommaSeparatedNumbers()
    {
        assertEquals( 6,  stringCalculator.add("1\n2,3"));
    }

    @Test 
    public void testCustomDelimiter()
    {
        assertEquals( 3,  stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testHandleNegativeNumbers()
    {
        try
        {
            stringCalculator.add("-1,2,-8");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Negatives not allowed: [-1,-8]", e.getMessage());
        }
    }

    @Test
    public void testIgnoreNumbersGreaterThan1000()
    {
        assertEquals( 2,  stringCalculator.add("1001,2"));
    }

    @Test
    public void testCustomDelimiterOfAnyLength()
    {
        assertEquals( 6,  stringCalculator.add("//[***]\n1***2***3"));
    }
}