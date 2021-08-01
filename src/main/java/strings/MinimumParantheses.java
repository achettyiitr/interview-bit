package strings;

import java.util.Stack;

public class MinimumParantheses {
    public class Solution {
        public int solve(String A) {
            int count = 0;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        count++;
                    } else {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            count++;
                        }
                    }
                }
            }
            return count + stack.size();
        }
    }
}
