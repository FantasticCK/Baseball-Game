package com.CK;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
//        new Solution().calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"});
        new Solution().calPoints(new String[]{"5", "2", "C", "D", "+"});
    }
}

class Solution {
    public int calPoints(String[] ops) {
        if (ops.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            if (s.equals("C")) {
                if (stack.isEmpty())
                    continue;
                sum -= stack.pop();
            } else if (s.equals("D")) {
                if (stack.isEmpty())
                    continue;
                stack.push(2 * stack.peek());
                sum += stack.peek();
            } else if (s.equals("+")) {
                if (stack.isEmpty())
                    continue;
                int first = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(first);
                    sum += stack.peek();
                    continue;
                }
                int second = stack.pop();
                stack.push(second);
                stack.push(first);
                stack.push(first + second);
                sum += stack.peek();
            } else {
                stack.push(Integer.parseInt(s));
                sum += stack.peek();
            }
        }
        return sum;
    }
}