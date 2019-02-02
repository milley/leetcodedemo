package com.milley.structure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private Map<Character, Character> mapping;

    public ValidParentheses() {
        this.mapping = new HashMap<>(3);
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (this.mapping.containsKey(ch)) {
               char topElement = stack.isEmpty() ? '#' : (char)stack.pop();
               if (topElement != this.mapping.get(ch)) {
                   return false;
               }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
