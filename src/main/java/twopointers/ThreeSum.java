package twopointers;

import java.util.Arrays;

public class ThreeSum {
    public class Solution {
        public int threeSumClosest(int[] A, int B) {
            Arrays.sort(A);
            int ans = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < A.length - 2; i++) {
                int start = i + 1, end = A.length - 1;
                while (start < end) {
                    int sum = A[i] + A[start] + A[end];
                    if (minDiff > Math.abs(sum - B)) {
                        minDiff = Math.abs(sum - B);
                        ans = sum;
                    }
                    if (sum - B == 0) return sum;
                    else if (sum - B > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
            return ans;
        }
    }
}
