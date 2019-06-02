package com.milley.multiplytable;

public class Multiply {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("\t %d * %d = %d", j, i, i * j);
                if (i == j) {
                    System.out.println("\n");
                    break;
                }
            }
        }
    }
}
