package com.milley.twosum;

import org.junit.Test;

import static com.milley.twosum.Solution.twoSum;
import static com.milley.twosum.Solution.twoSum1;
import static com.milley.twosum.Solution.twoSum2;
import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private static final int[] nums = {2, 7, 11, 15};
    private static final int target = 9;
    private static final int target1 = 18;

    private int[] getIndices(int[] nums, int target, int index) {
        switch (index) {
            case 0:
                return twoSum(nums, target);
            case 1:
                return twoSum1(nums, target);
            case 2:
                return twoSum2(nums, target);
            default:
                return twoSum2(nums, target);
        }
    }
    @Test
    public void twoSumTest() {
        int[] twoNums = getIndices(nums, target, 0);
        assertEquals(twoNums[0], 0);
        assertEquals(twoNums[1], 1);

        twoNums = getIndices(nums, target1, 0);
        assertEquals(twoNums[0], 1);
        assertEquals(twoNums[1], 2);
    }

    @Test
    public void twoSumTest1() {
        int[] twoNums = getIndices(nums, target, 1);
        assertEquals(twoNums[0], 0);
        assertEquals(twoNums[1], 1);

        twoNums = getIndices(nums, target1, 1);
        assertEquals(twoNums[0], 1);
        assertEquals(twoNums[1], 2);
    }

    @Test
    public void twoSumTest2() {
        int[] twoNums = getIndices(nums, target, 2);
        assertEquals(twoNums[0], 0);
        assertEquals(twoNums[1], 1);

        twoNums = getIndices(nums, target1, 0);
        assertEquals(twoNums[0], 1);
        assertEquals(twoNums[1], 2);
    }
}
