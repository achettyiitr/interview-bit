package hashing;

import java.util.*;

public class Anagrams {
    public class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            Map<String, ArrayList<Integer>> map = new HashMap<>();
            ArrayList<String> nA = new ArrayList<>();
            for (int i = 0; i < A.size(); i++) {
                char[] arr = A.get(i).toCharArray();
                Arrays.sort(arr);
                String ns = new String(arr);
                if (map.containsKey(ns)) {
                    map.get(ns).add(i + 1);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i + 1);
                    map.put(ns, list);
                }
                nA.add(ns);
            }
            for (int i = 0; i < A.size(); i++) {
                String ss = nA.get(i);
                if (map.containsKey(ss)) {
                    ArrayList<Integer> sl = map.get(ss);
                    results.add(sl);
                    map.remove(ss);
                }
            }
            return results;
        }
    }
}
