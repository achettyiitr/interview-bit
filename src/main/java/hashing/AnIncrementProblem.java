package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AnIncrementProblem {
    public class Solution {
        public ArrayList<Integer> solve(ArrayList<Integer> A) {
            Map<Integer, LinkedList<Integer>> map = new HashMap<>();
            for (int i = 0; i < A.size(); i++) {
                if (map.containsKey(A.get(i))) {
                    LinkedList<Integer> ll1 = map.get(A.get(i));
                    int index = ll1.get(0);
                    A.set(index, A.get(i) + 1);

                    LinkedList<Integer> ll2 = map.get(A.get(i) + 1);
                    if (ll2 == null) {
                        ll2 = new LinkedList<>();
                    }
                    ll2.add(0, index);
                    ll1.add(i);
                    ll1.remove(0);
                    map.put(A.get(i) + 1, ll2);
                    map.put(A.get(i), ll1);
                } else {
                    LinkedList<Integer> ll = new LinkedList<>();
                    ll.add(i);
                    map.put(A.get(i), ll);
                }
            }
            return A;
        }
    }
}
