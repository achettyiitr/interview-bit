package twopointers;

import java.util.ArrayList;

public class RemoveElementFromArray {
    public class Solution {
        public int removeElement(ArrayList<Integer> a, int b) {
            int i = 0, j = 0;
            while (j < a.size()) {
                if (a.get(j) == b) {
                    j++;
                } else {
                    a.set(i, a.get(j));
                    i++;
                    j++;
                }
            }
            return i;
        }
    }
}
