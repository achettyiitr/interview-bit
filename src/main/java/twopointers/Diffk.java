package twopointers;

public class Diffk {
    public class Solution {
        public int solve(int[] A, int B) {
            int start = 0, end = 0, count = 0, ans = 0, n = A.length;
            while (end < n) {
                if (A[end] == 1) {
                    count++;
                    end++;
                } else {
                    if (B > 0) {
                        B--;
                        count++;
                        end++;
                    } else {
                        if (A[start] == 0) B++;
                        start++;
                        count--;
                    }
                }
                ans = Math.max(ans, count);
            }
            return ans;
        }
    }
}
