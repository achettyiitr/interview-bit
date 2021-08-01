package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LargestContinuousSequenceZeroSum {
    public class Solution {
        public ArrayList<Integer> lszero(ArrayList<Integer> A) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0, start = -1, end = -1;
            for (int i = 0; i < A.size(); i++) {
                sum += A.get(i);
                if (sum == 0) {
                    start = 0;
                    end = i;
                } else {
                    if (map.containsKey(sum)) {
                        int mindex = map.get(sum);
                        if (start == -1 || (end - start + 1) < (i - mindex)) {
                            start = mindex + 1;
                            end = i;
                        }
                    }
                }

                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            if (start != -1) {
                for (int i = start; i <= end; i++) {
                    result.add(A.get(i));
                }
            }
            return result;
        }
    }
}
