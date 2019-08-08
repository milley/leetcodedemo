package com.milley.structure.calculate;

/**
 * @author milley
 */
public class SqrtDemo {
    /**
     * 计算大于1的平方根
     * @param n 待计算的数
     * @param deltaThreshold 误差的阀值
     * @param maxTry 二分查找最大次数
     * @return 平方根
     */
    public static double getSquareRoot(int n, double deltaThreshold, int maxTry) {
        if (n <= 1) {
            return -1.0;
        }

        double min = 1.0, max = (double)n;
        for (int i = 0; i < maxTry; i++) {
            double middle = min + (max - min) / 2;
            double square = middle * middle;
            double delta = Math.abs((square/n) - 1);
            if (delta <= deltaThreshold) {
                return middle;
            } else {
                if (square > n) {
                    max = middle;
                } else {
                    min = middle;
                }
            }
        }

        return -2.0;
    }

    public static void main(String[] args) {
        System.out.println(getSquareRoot(10, 0.00000000001, 100000000));
        System.out.println(getSquareRoot(2, 0.000001, 10000));
    }
}
