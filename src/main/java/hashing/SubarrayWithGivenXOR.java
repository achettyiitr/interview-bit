package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubarrayWithGivenXOR {
    public class Solution {
        public int solve(ArrayList<Integer> A, int B) {
            Map<Integer, Integer> map = new HashMap<>();
            int xor = 0, count = 0;
            for (int i = 0; i < A.size(); i++) {
                xor ^= A.get(i);
                if (xor == B) {
                    count++;
                }
                if (map.containsKey(B^xor)) {
                    count += map.get(B^xor);
                }
                map.put(xor, map.getOrDefault(xor, 0) + 1);
            }
            return count;
        }
    }
}
