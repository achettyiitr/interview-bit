package stacksandqueues;

import java.util.Stack;

public class MAXSPPROD {
    public class Solution {
        public int maxSpecialProduct(int[] A) {
            int n = A.length, mod = 1000000007;
            long ans = 0;
            int NGEL[] = nearestGreateestElementOnLeft(A);
            int NGER[] = nearestGreateestElementOnRight(A);

            for (int i = 1; i < n - 1; i++) {
                if (NGEL[i] != -1 && NGER[i] != -1) {
                    ans = Math.max(ans, (long)NGEL[i] * (long)NGER[i]);
                }
            }
            return (int)(ans % mod);
        }

        private int[] nearestGreateestElementOnLeft(int[] arr) {
            int n = arr.length;
            int[] r = new int[n];
            r[0] = -1;
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (int i = 1; i < n; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    r[i] = -1;
                } else {
                    r[i] = stack.peek();
                }
                stack.push(i);
            }
            return r;
        }
        private int[] nearestGreateestElementOnRight(int[] arr) {
            int n = arr.length;
            int[] r = new int[n];
            r[n - 1] = -1;
            Stack<Integer> stack = new Stack<>();
            stack.push(n - 1);
            for (int i = n - 2; i >= 0; i--) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    r[i] = -1;
                } else {
                    r[i] = stack.peek();
                }
                stack.push(i);
            }
            return r;
        }
    }
}
