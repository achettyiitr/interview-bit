package twopointers;

import java.util.ArrayList;

public class MergeTwoSortedListsII {
    public class Solution {
        public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
            int i = 0, j = 0, m = a.size(), n = b.size();
            while (i < m && j < n) {
                if (a.get(i) <= b.get(j)) {
                    i++;
                } else {
                    a.add(i, b.get(j));
                    i++;
                    m++;
                    j++;
                }
            }
            while (j < n) {
                a.add(b.get(j));
                j++;
            }
        }
    }
}
