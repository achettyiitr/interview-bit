package stacksandqueues;

import java.util.Collections;
import java.util.Stack;

public class SimplifyDirectoryPath {
    public class Solution {
        public String simplifyPath(String A) {
            Stack<String> stack = new Stack<>();
            String[] paths = A.split("/");
            StringBuilder sb = new StringBuilder("/");
            for (String temp: paths) {
                String path = temp.trim();
                if (path.length() == 0) continue;
                else if (path.equals(".")) continue;
                else if (path.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(path);
                }
            }
            Collections.reverse(stack);
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
                sb.append('/');
            }
            if (sb.length() > 1) {
                return sb.substring(0, sb.length() - 1);
            } else {
                return sb.toString();
            }
        }
    }

}
