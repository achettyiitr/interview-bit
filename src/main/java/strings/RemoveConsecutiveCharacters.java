package strings;

import java.util.Stack;

public class RemoveConsecutiveCharacters {
    public class Solution {
        public String solve(String A, int B) {
            Stack<Character> stack = new Stack<>();
            int i = 0, n = A.length();
            while (i < n) {
                char ch = A.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else {
                    char sp = stack.peek();
                    if (sp == ch) {
                        int count = 1;
                        while (i < n && A.charAt(i) == sp) {
                            count++;
                            i++;
                        }
                        if (count == B) {
                            stack.pop();
                        } else {
                            for (int j = 1; j < count; j++) {
                                stack.push(sp);
                            }
                        }
                        if (i < n) {
                            stack.push(A.charAt(i));
                        }
                    } else {
                        stack.push(ch);
                    }
                }
                i++;
            }
            StringBuilder sb = new StringBuilder("");
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }
}
