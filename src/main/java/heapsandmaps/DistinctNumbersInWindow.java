package heapsandmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {
    public class Solution {
        public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
            ArrayList<Integer> result = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            int i = 0, j = 0;
            int n = A.size();
            while (j < n) {
                map.put(A.get(j), map.getOrDefault(A.get(j), 0) + 1);
                if (j - i + 1 < B) {
                    j++;
                } else {
                    result.add(map.size());
                    map.put(A.get(i), map.getOrDefault(A.get(i), 0) - 1);
                    if (map.get(A.get(i)) == 0) {
                        map.remove(A.get(i));
                    }
                    i++;
                    j++;
                }
            }
            return result;
        }
    }
}
