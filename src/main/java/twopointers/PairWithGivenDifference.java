package twopointers;

import java.util.Arrays;

public class PairWithGivenDifference {
    public class Solution {
        public int solve(int[] A, int B) {
            Arrays.sort(A);
            int n = A.length, start = 0, end = 0;
            while (start < n && end < n) {
                if (start != end && A[end] - A[start] == B) {
                    return 1;
                } else if (A[end] - A[start] < B) {
                    end++;
                } else {
                    start++;
                }
            }
            return 0;
        }
    }
}
