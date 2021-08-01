package stacksandqueues;

import java.util.Stack;

public class NearestSmallerElement {
    public class Solution {
        public int[] prevSmaller(int[] A) {
            int n = A.length;
            int nse[] = new int[n];
            nse[0] = -1;
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (int i = 1; i< n; i++) {
                while (!stack.isEmpty() && A[stack.peek()] >= A[i]) stack.pop();
                if (stack.isEmpty()) {
                    nse[i] = -1;
                } else {
                    nse[i] = A[stack.peek()];
                }
                stack.push(i);
            }
            return nse;
        }
    }
}
