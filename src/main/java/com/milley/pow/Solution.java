package com.milley.pow;

/**
 * @author milley
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / myPow(x, -n - 1) * x;
            } else {
                return 1 / myPow(x, -n);
            }
        }
        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        }
        return myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(1.00000, -2147483648));
        System.out.println(new Solution().myPow(2.00000, -2));
    }
}
