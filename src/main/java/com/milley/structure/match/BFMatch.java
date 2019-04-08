package com.milley.structure.match;

public class BFMatch {
    /**
     * search the module in the primary, if not exists return -1,else return the index
     * @param primary
     * @param module
     * @return index of primary that equals with module
     */
    public static int bfMatch(String primary, String module) {
        int n = primary.length();
        int m = module.length();
        if (n < m) return -1;
        for (int i = 0; i < n - m + 1; i++) {
            if (module.equals(primary.substring(i, i + m))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String primary = "aaaabaaaabc";
        String module = "abaa";
        System.out.println(bfMatch(primary, module));
    }
}
