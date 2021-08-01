package twopointers;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArrayII {
    public class Solution {
        public int removeDuplicates(ArrayList<Integer> a) {
            int i = 0, j = 1, count = 1;
            while (j < a.size()) {
                if (Integer.compare(a.get(i), a.get(j)) == 0) {
                    count++;
                    if (count > 2) {
                        while (j < a.size() && Integer.compare(a.get(i), a.get(j)) == 0) j++;
                    } else {
                        i++;
                        a.set(i, a.get(j));
                        j++;
                    }
                } else {
                    i++;
                    a.set(i, a.get(j));
                    j++;
                    count = 1;
                }
            }
            return i + 1;
        }
    }
}
