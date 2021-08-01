package hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {
    public class Solution {
        public int solve(int[] A) {
            Map<Integer, Integer> map = new HashMap<>();
            int index = Integer.MAX_VALUE;
            for (int i = 0; i < A.length; i++) {
                if (map.containsKey(A[i])) {
                    index = Math.min(index, map.get(A[i]));
                } else {
                    map.put(A[i], i);
                }
            }
            if (index == Integer.MAX_VALUE) {
                return -1;
            } else {
                return A[index];
            }
        }
    }
}
