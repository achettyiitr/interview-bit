package stacksandqueues;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public class Solution {
        public int largestRectangleArea(int[] A) {
            int nseL[] = nearestSmallestOnLeft(A);
            int nseR[] = nearestSmallestOnRight(A);
            int ma = 0, n = A.length;
            for (int i = 0; i < n; i++) {
                // System.out.println((nseR[i] - nseL[i] - 1));
                ma = Math.max(ma, (nseR[i] - nseL[i] - 1) * A[i]);
            }
            return ma;
        }

        public int[] nearestSmallestOnLeft(int[] A) {
            int n = A.length;
            int nse[] = new int[n];
            nse[0] = -1;
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (int i = 1; i < n; i++) {
                while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                    stack.pop();
                if (stack.isEmpty()) {
                    nse[i] = -1;
                } else {
                    nse[i] = stack.peek();
                }
                stack.push(i);
            }
            return nse;
        }

        public int[] nearestSmallestOnRight(int[] A) {
            int n = A.length;
            int nse[] = new int[n];
            nse[n - 1] = n;
            Stack<Integer> stack = new Stack<>();
            stack.push(n - 1);
            for (int i = n - 2; i >= 0; i--) {
                while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                    stack.pop();
                if (stack.isEmpty()) {
                    nse[i] = n;
                } else {
                    nse[i] = stack.peek();
                }
                stack.push(i);
            }
            return nse;
        }
    }
}
