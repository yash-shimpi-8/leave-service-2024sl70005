package com.bits.leave;

import org.junit.Test;
import static org.junit.Assert.*;

public class LeaveCalculatorTest {

    LeaveCalculator calculator = new LeaveCalculator();

    @Test
    public void testRemainingLeaves() {
        assertEquals(10, calculator.getRemainingLeaves(30, 20));
    }

    @Test
    public void testEncashmentAmount() {
        assertEquals(15000.0, calculator.getEncashmentAmount(10, 1500.0), 0.01);
    }

    @Test
    public void testZeroRemainingLeaves() {
        assertEquals(0.0, calculator.getEncashmentAmount(0, 1500.0), 0.01);
    }
}
