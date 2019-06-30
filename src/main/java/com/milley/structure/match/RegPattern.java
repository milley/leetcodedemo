package com.milley.structure.match;

/**
 * Regex Pattern
 */
public class RegPattern {
    private boolean matched = false;
    /**
     * 正则表达式
     */
    private char[] pattern;
    /**
     * 正则表达式长度
     */
    private int plen;

    public RegPattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    /**
     * 匹配文本串及长度
     * @param text 文本串
     * @param tlen 长度
     * @return
     */
    public boolean match(char[] text, int tlen) {
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    /**
     * 循环匹配正则表达式
     * @param ti
     * @param pj
     * @param text
     * @param tlen
     */
    private void rmatch(int ti, int pj, char[] text, int tlen) {
        // 如果已经匹配了，就不要递归了
        if (matched) {
            return;
        }
        // 正则表达式到结尾了
        if (pj == plen) {
            if (ti == tlen) {
                // 文本串也到结尾了
                matched = true;
                return;
            }
        }
        if (pattern[pj] == '*') {
            // * 匹配任意多个字符
            for (int k = 0; k <= tlen - ti; k++) {
                rmatch(ti + k, pj + 1, text, tlen);
            }
        } else if (pattern[pj] == '?') {
            // ? 匹配0个或者1个字符
            rmatch(ti, pj + 1, text, tlen);
            rmatch(ti + 1, pj + 1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) {
            // 纯字符匹配才行
            rmatch(ti + 1, pj + 1, text, tlen);
        }
    }

    public static void main(String[] args) {
        RegPattern regPattern = new RegPattern("A*b,?1".toCharArray(), 6);
        String inputStr = "A123ABCb,1";
        System.out.println(regPattern.match(inputStr.toCharArray(), inputStr.length()));
        inputStr = "Ab,,1";
        System.out.println(regPattern.match(inputStr.toCharArray(), inputStr.length()));
    }
}
