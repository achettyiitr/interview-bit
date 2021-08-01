package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    public class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < A.size(); i++) {
                int val = A.get(i);
                if (map.containsKey(B - val)) {
                    result.add(map.get(B - val) + 1);
                    result.add(i + 1);
                    return result;
                }
                if (!map.containsKey(val)) {
                    map.put(val, i);
                }
            }
            return result;
        }
    }
}
