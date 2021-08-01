package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class SubMatricesWithSumZero {
    public class Solution {
        public int solve(int[][] A) {
            int m = A.length;
            if (m == 0) {
                return 0;
            }
            int n = A[0].length;
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] += A[i - 1][j];
                }
            }
            int tc = 0;
            for (int i = 0; i < m; i++) {
                for (int j = i; j < m; j++) {
                    if (i > 0) {
                        for (int k = 0; k < n; k++) {
                            A[j][k] -= A[i - 1][k];
                        }
                    }
                    tc += countOfSumKInContinuousSubArrays(A[j], 0);
                    // System.out.println(cc);
                    if (i > 0) {
                        for (int k = 0; k < n; k++) {
                            A[j][k] += A[i - 1][k];
                        }
                    }
                }
            }
            return tc;
        }

        private int countOfSumKInContinuousSubArrays(int[] arr, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(k, 1);
            int sum = 0, count = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                count += map.getOrDefault(sum - k, 0);
                map.put(sum ,map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}
