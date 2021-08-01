package stacksandqueues;

import java.util.Stack;

public class RedundantBraces {
    public class Solution {
        public int braces(String A) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                switch(ch) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '(': {
                        stack.push(ch);
                        break;
                    }
                    case ')': {
                        if (stack.peek() == '(') {
                            return 1;
                        } else {
                            while (!stack.isEmpty()) {
                                if (stack.peek() == '(') {
                                    stack.pop();
                                    break;
                                } else {
                                    stack.pop();
                                    continue;
                                }
                            }
                        }
                        break;
                    }
                }
            }
            return 0;
        }
    }
}
