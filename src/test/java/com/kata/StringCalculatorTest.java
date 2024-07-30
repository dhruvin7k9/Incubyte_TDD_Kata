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

    @Test
    public void testCommaSeparatedNumbers()
    {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals( 13,  stringCalculator.add("1,2,10"));
    }

    @Test
    public void testNewLineAndCommaSeparatedNumbers()
    {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals( 6,  stringCalculator.add("1\n2,3"));
    }

    @Test 
    public void testCustomDelimiter()
    {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals( 3,  stringCalculator.add("//;\n1;2"));
    }
}