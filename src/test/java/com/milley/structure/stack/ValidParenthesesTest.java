package com.milley.structure.stack;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ValidParenthesesTest {
    private ValidParentheses validParentheses;

    @Test
    public void isValidTest() {
        validParentheses = new ValidParentheses();
        assertTrue(validParentheses.isValid("()"));
        assertTrue(validParentheses.isValid("()[]{}"));
        assertFalse(validParentheses.isValid("(]"));
        assertFalse(validParentheses.isValid("([)]"));
        assertTrue(validParentheses.isValid("{[]}"));
    }
}
