package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayLength {
    public class Solution {
        public int solve(int[] A) {
            int n = A.length;
            Map<Integer, Integer> map = new HashMap<>();
            int maxLength = 0;
            int ones = 0, zeroes = 0;
            for (int i = 0; i < n; i++) {
                ones += (A[i] == 1) ? 1 : 0;
                zeroes += (A[i] == 0) ? 1 : 0;
                if (ones == zeroes + 1) {
                    maxLength = i + 1;
                }
                if (map.containsKey(ones - zeroes - 1)) {
                    maxLength = Math.max(maxLength, i - map.get(ones - zeroes - 1));
                }
                if (!map.containsKey(ones - zeroes)) {
                    map.put(ones - zeroes, i);
                }
            }
            return maxLength;
        }
    }
}
