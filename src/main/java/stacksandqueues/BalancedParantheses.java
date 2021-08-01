package stacksandqueues;

import java.util.Stack;

public class BalancedParantheses {
    public class Solution {
        public int solve(String A) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                switch (ch) {
                    case '(': {
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

                }
            }
            return stack.isEmpty() ? 1 : 0;
        }
    }
}
