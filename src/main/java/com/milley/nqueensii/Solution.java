package com.milley.nqueensii;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author milley
 */
public class Solution {
    private static int count = 0;
    /**
     * add for print
     */
    private Set<Integer> currSet = new LinkedHashSet<>();
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        helper(0, cols, d1, d2, n);
        return count;
    }

    private void helper(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (row == n) {
            System.out.println(currSet);
            count++;
        } else {
            for (int col = 0; col < n; col++) {
                int id1 = col - row + n;
                int id2 = col + row;
                if (cols[col] || d1[id1] || d2[id2]) {
                    continue;
                }

                cols[col] = true; d1[id1] = true; d2[id2] = true;
                currSet.add(col);
                helper(row + 1, cols, d1, d2, n);
                cols[col] = false; d1[id1] = false; d2[id2] = false;
                currSet.remove(col);
            }
        }
    }

    public int totalNQueensWithBit(int n) {
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    private static int getSeqOfOneFromLowEndian(int n) {
        int seq = 0;
        if (n == 0) {
            return seq;
        }
        while (n > 0) {
            if ((n & 1)  == 1) {
                return seq;
            } else {
                seq++;
                n = n >> 1;
            }
        }
        return seq;
    }

    private void printNumbers(Set<Integer> set) {
        for (Integer i : set) {
            System.out.print(getSeqOfOneFromLowEndian(i.intValue())+ " ");
        }
        System.out.println();
    }

    private void dfs(int n, int row, int cols, int pie, int na) {
        if (row >= n) {
            count++;
            // System.out.println(currSet);
            printNumbers(currSet);
            return;
        }

        // 得到所有的空位
        int bits = (~(cols | pie | na)) & ((1 << n) - 1);
        while (bits > 0) {
            // 取最低位的1
            int p = bits & -bits;
            currSet.add(p);
            dfs(n, row + 1, cols | p, (pie | p) << 1,
                    (na | p) >> 1);
            // 去掉最低位的1
            bits = bits & (bits - 1);
            currSet.remove(p);
        }
    }

    public static void main(String[] args) {
        new Solution().totalNQueens(4);
        new Solution().totalNQueensWithBit(4);
        System.out.println(count);
    }
}
