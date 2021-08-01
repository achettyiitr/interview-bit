package arrays;

public class MinimumLightsToActivate {
    public class Solution {
        public int solve(int[] A, int B) {
            int last = 0, i = 0, count = 0, n = A.length;
            while (i < n) {
                int j = Math.min(i + B - 1, n - 1);
                boolean isFound = false;
                while (j >= last) {
                    if (A[j] == 1) {
                        last = j + 1;
                        i = j + B;
                        count++;
                        isFound = true;
                        break;
                    }
                    j--;
                }
                if (!isFound) return -1;
            }
            return count;
        }
    }
}
