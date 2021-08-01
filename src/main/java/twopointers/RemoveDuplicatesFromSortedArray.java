package twopointers;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {
    public class Solution {
        public int removeDuplicates(ArrayList<Integer> a) {
            int i = 0, j = 1;
            while (j < a.size()) {
                // System.out.println(a.get(i) + " " + a.get(j));
                if (Integer.compare(a.get(i), a.get(j)) == 0) j++;
                else {
                    i++;
                    a.set(i, a.get(j));
                    j++;
                }
            }
            return i + 1;
        }
    }
}
