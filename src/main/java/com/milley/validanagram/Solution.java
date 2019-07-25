package com.milley.validanagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int ALPHABET_SIZE = 26;

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>(s.length());
        Map<Character, Integer> tMap = new HashMap<>(t.length());

        for (Character ch : s.toCharArray()) {
            int v = sMap.get(ch) == null ? 0 : sMap.get(ch);
            sMap.put(ch, ++v);
        }

        for (Character ch : t.toCharArray()) {
            int v = tMap.get(ch) == null ? 0 : tMap.get(ch);
            tMap.put(ch, ++v);
        }

        return sMap.equals(tMap);
    }

    public boolean isAnagramB(String s, String t) {
        int[] sArray = new int[ALPHABET_SIZE];
        int[] tArray = new int[ALPHABET_SIZE];

        for (char ch : s.toCharArray()) {
            sArray[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            tArray[ch - 'a']++;
        }

        /*for (int i = 0, j = 0; i < ALPHABET_SIZE && j < ALPHABET_SIZE;) {
            if (sArray[i] != tArray[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;*/
        //return Arrays.equals(sArray, tArray);
        return sArray.equals(tArray);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagramB("anagram", "nagaram"));
    }
}
