// BITS ID: 2024sl70005
package com.bits.leave;

public class LeaveCalculator {

    public int getRemainingLeaves(int totalLeaves, int usedLeaves) {
        return totalLeaves - usedLeaves;
    }

    public double getEncashmentAmount(int remainingLeaves, double dailySalary) {
        return remainingLeaves * dailySalary;
    }
}
