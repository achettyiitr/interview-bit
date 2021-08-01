package dynamicprogramming;

import java.util.Stack;

public class MaxRectangleInBinaryMatrix {
    public class Solution {
        public int maximalRectangle(int[][] A) {
            int m = A.length;
            int n = A[0].length;
            int[] L = new int[n], R = new int[n];
            Stack<Integer> stack = new Stack<>();
            int ans = largestAreaHistogream(A[0], stack, L, R);
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i][j] == 1) {
                        A[i][j] += A[i - 1][j];
                    }
                }
                ans = Math.max(ans, largestAreaHistogream(A[i], stack, L, R));
            }
            return ans;
        }

        private int largestAreaHistogream(int[] A, Stack<Integer> stack, int[] NSEL, int[] NSER) {
            int n = A.length;

            stack.clear();
            NSEL[0] = -1;
            stack.push(0);
            for (int i = 1; i < n; i++) {
                while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    NSEL[i] = -1;
                } else {
                    NSEL[i] = stack.peek();
                }
                stack.push(i);
            }

            stack.clear();
            NSER[n - 1] = n;
            stack.push(n - 1);
            for (int i = n - 2; i >= 0; i--) {
                while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    NSER[i] = n;
                } else {
                    NSER[i] = stack.peek();
                }
                stack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, (NSER[i] - NSEL[i] - 1) * A[i]);
            }
            // System.out.println(Arrays.toString(A));
            // System.out.println(Arrays.toString(NSEL));
            // System.out.println(Arrays.toString(NSER));
            // System.out.println(ans);
            return ans;
        }
    }
}
