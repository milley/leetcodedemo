package com.milley.MaximumSubarray;

public class BruteSolution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int currSum = sum(nums, i, j);
                if (maxSum < currSum) {
                    maxSum = currSum;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("start=" + String.valueOf(start) + ", end=" + String.valueOf(end));
        return maxSum;
    }

    private int sum(int[] nums, int start, int end) {
        int n = nums.length;
        int result = 0;
        if (start > end || start >= n) throw new IllegalArgumentException("Argument error");
        for (int i = start; i <= end; i++) {
            result += nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        BruteSolution bruteSolution = new BruteSolution();
        System.out.println(bruteSolution.maxSubArray(nums));
    }
}
