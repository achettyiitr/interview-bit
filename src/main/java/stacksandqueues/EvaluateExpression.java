package stacksandqueues;

import java.util.Stack;

public class EvaluateExpression {
    public class Solution {
        public int evalRPN(String[] A) {
            int result = 0;
            String symbols = "+-*/";
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < A.length; i++) {
                String val = A[i];
                if (symbols.indexOf(val) >= 0) {
                    char ch = val.charAt(0);
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    switch(ch) {
                        case '+': {
                            stack.push(val1 + val2);
                            break;
                        }
                        case '-': {
                            stack.push(val1 - val2);
                            break;
                        }
                        case '*': {
                            stack.push(val1 * val2);
                            break;
                        }
                        case '/': {
                            stack.push(val1 / val2);
                        }
                    }
                } else {
                    stack.push(Integer.parseInt(val));
                }
            }
            return stack.pop();
        }
    }
}
