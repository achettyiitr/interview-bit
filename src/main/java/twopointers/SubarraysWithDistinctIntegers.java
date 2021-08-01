package twopointers;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithDistinctIntegers {
    public class Solution {
        public int solve(int[] A, int B) {
            int atmostK = solveForAtMostB(A, B);
            int atmostKMinusOne = solveForAtMostB(A, B - 1);
            return atmostK - atmostKMinusOne;
        }

        private int solveForAtMostB(int[] A, int B) {
            int start = 0, end = 0, count = 0, result = 0;
            Map<Integer, Integer> map = new HashMap<>();

            while (end < A.length) {
                map.put(A[end], map.getOrDefault(A[end], 0) + 1);
                if (map.size() > B) {
                    while (map.size() > B) {
                        map.put(A[start], map.getOrDefault(A[start], 0) - 1);
                        if (map.get(A[start]) == 0) {
                            map.remove(A[start]);
                        }
                        count--;
                        start++;
                    }
                    count++;
                    result += count;
                } else {
                    count++;
                    result += count;
                }
                end++;
            }
            return result;
        }
    }
}
