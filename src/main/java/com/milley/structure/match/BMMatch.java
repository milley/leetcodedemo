package com.milley.structure.match;

public class BMMatch {
    private static final int SIZE = 256;    // 散列表大小

    /**
     * build BC array
     * @param b module array
     * @param m length of module array
     * @param bc BC array
     */
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < m; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int ascii = (int)b[i];
            bc[ascii] = i;
        }
    }

    /**
     * BM match primary process
     * @param a primary array
     * @param n length of primary array
     * @param b module array
     * @param m length of module array
     * @return index of matched array
     */
    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE];   // 记录模式串中每个字符出现的位置
        generateBC(b, m, bc);   // 构建坏字符哈希表
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0;  // i表示主串与模式串对齐的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; j--) {  // 模式串从后往前匹配
                if (a[i+j] != b[j]) {
                    break;  // 坏字符的下标为j
                }
            }
            if (j < 0) {
                return i;   // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            int x = j - bc[(int)a[i + j]];
            int y = 0;
            if (y < m - 1) {
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    /**
     * move by gs
     * @param j index of bad character in the module array
     * @param m length of module array
     * @param suffix suffix array
     * @param prefix prefix array
     * @return index of moving
     */
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j;  // 好后缀长度
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        for (int r = j + 2; r <= m - 1; r++) {
            if (prefix[m - r] == true) {
                return r;
            }
        }
        return m;
    }

    /**
     * generate suffix and prefix arrays
     * @param b module array
     * @param m length of module array
     * @param suffix
     * @param prefix
     */
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        for (int i = 0; i < m - 1; i++) {
            int j = i;
            int k = 0;  // 公共后缀子串长度
            while (j >= 0 && b[j] == b[m - 1 - k]) {    // 与 b[0, m - 1]求公共后缀子串
                --j;
                ++k;
                suffix[k] = j + 1;  // j + 1表示公共后缀子串在 b[0, i] 中的起始下标
            }

            if (j == -1) {
                prefix[k] = true;   // 如果公共后缀子串也是模式串的前缀子串
            }
        }

    }
}
