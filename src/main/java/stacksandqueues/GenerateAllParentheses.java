package stacksandqueues;

import java.util.Stack;

public class GenerateAllParentheses {
    public class Solution {
        public int isValid(String A) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                switch(ch) {
                    case '(':
                    case '[':
                    case '{': {
                        stack.push(ch);
                        break;
                    }
                    case ')': {
                        if (stack.isEmpty() || stack.peek() != '(') {
                            return 0;
                        } else {
                            stack.pop();
                            break;
                        }
                    }
                    case ']': {
                        if (stack.isEmpty() || stack.peek() != '[') {
                            return 0;
                        } else {
                            stack.pop();
                            break;
                        }
                    }
                    case '}': {
                        if (stack.isEmpty() || stack.peek() != '{') {
                            return 0;
                        } else {
                            stack.pop();
                            break;
                        }
                    }
                }
            }
            return stack.isEmpty() ? 1 : 0;
        }
    }
}
