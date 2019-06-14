package com.milley.structure.search;


/**
 * @author milley
 */
public class EightQueue {
    private int[] result;

    public EightQueue() {
        this.result = new int[8];
    }

    public void cal8queues(int row) {
        // 8个棋子都放好了，return
        if (row == 8) {
            printQueues(result);
            return;
        }

        // 每一行都有8种放法
        for (int column = 0; column < 8; ++column) {
            // 有些放法不满足要求
            if (isOk(row, column)) {
                // 第row行的棋子放到了column列
                result[row] = column;
                // 考察下一行
                cal8queues(row + 1);
            }
        }
    }

    /**
     * 判断row行column列是否合适
     * @param row 行
     * @param column 列
     * @return 是否满足
     */
    private boolean isOk(int row, int column) {
        int leftup = column - 1, rightup = column + 1;
        // 逐行往上考察每一行
        for (int i = row - 1; i >= 0; i--) {
            // 第i行的column列有棋子吗？
            if (result[i] == column) {
                return false;
            }

            // 考察左上对角线：第i行leftup列有棋子吗？
            if (leftup >= 0) {
                if (result[i] == leftup) {
                    return false;
                }
            }

            // 考察右上对角线：第i行rightup列有棋子吗？
            if (rightup < 8) {
                if (result[i] == rightup) {
                    return false;
                }
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    private void printQueues(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueue eightQueue = new EightQueue();
        eightQueue.cal8queues(0);
    }
}
