package com.milley.structure.stack;

import java.io.*;
import java.util.Stack;

public class AwesomeCalculator {
    public int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i) || i == len - 1)) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop()*num);
                }
                if (sign == '/') {
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }

    public static void main(String[] args) throws IOException {
        long startTime=System.nanoTime();
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("1+2*5/3+6/4*2"));
        System.out.println(calculator.calculate("3+5/2"));
        System.out.println(calculator.calculate("2+3-4"));
        System.out.println(calculator.calculate("3+2*2"));
        System.out.println(calculator.calculate("3/2 "));
        System.out.println(calculator.calculate("100000000/1/2/3/4/5/6/7/8/9/10"));


        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\test1.txt"))));

        StringBuilder builder = new StringBuilder();
        int charsRead = -1;
        char[] chars = new char[100];
        do{
            charsRead = in.read(chars,0,chars.length);
            //if we have valid chars, append them to end of string.
            if(charsRead>0) {
                builder.append(chars,0,charsRead);
            }
        }while(charsRead>0);
        String stringReadFromReader = builder.toString();
        System.out.println(calculator.calculate(stringReadFromReader));

        long endTime=System.nanoTime();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }
}
