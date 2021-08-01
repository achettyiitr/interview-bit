package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AntiDiagonals {
    public class Solution {
        public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            int r = A.size();
            int c = A.get(0).size();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map.containsKey(i + j)) {
                        map.get(i + j).add(A.get(i).get(j));
                    } else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(A.get(i).get(j));
                        map.put(i + j, temp);
                    }
                }
            }
            ArrayList<ArrayList<Integer>> o = new ArrayList<>();
            for (int i = 0; i < 2 * r - 1; i++) {
                o.add(map.get(i));
            }
            return o;
        }
    }
}
