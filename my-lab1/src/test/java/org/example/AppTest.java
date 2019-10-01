package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    Calculator testCalculator = new Calculator();
    Handler testHandler = new Handler();

    @Test
    public void testAdd() {
        double res = testCalculator.add("1 2 3 4");
        assertEquals(10.0, res, 0.0);
    }

    @Test
    public void testMinus() {
        double res = testCalculator.minus("90 10 20");
        assertEquals(60.0, res, 0.0);
    }

    @Test
    public void testMultiply() {
        double res = testCalculator.multiply("5 5 5");
        assertEquals(125.0, res, 0.0);
    }

    @Test
    public void testDivide() {
        double res = testCalculator.divide("125 5 5");
        assertEquals(5.0, res, 0.0);
    }

    @Test
    public void testPower() {
        double res = testCalculator.power("2 2 2");
        assertEquals(16.0, res, 0.0);
    }

    @Test
    public void testSquare() {
        double res = testCalculator.square("2");
        assertEquals(4.0, res, 0.0);
    }

    @Test
    public void testSquareRoot() {
        double res = testCalculator.squareRoot("16");
        assertEquals(4.0, res, 0.0);
    }


    @Test
    public void testLog() {
        double res = testCalculator.log("1");
        assertEquals(0.0, res, 0.0);
    }

    @Test
    public void testFormat() {
        assertTrue(testHandler.isNumericBoolean("22 2 2.3 1.2 0.8829"));
        assertFalse(testHandler.isNumericBoolean("hello world"));
    }

    @Test
    public void testForDivide() {
        assertTrue(testHandler.checkNumberForDivideBoolean(19.2));
        assertFalse(testHandler.checkNumberForDivideBoolean(0.0));
    }
}
