package twopointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {
    public class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
            ArrayList<Integer> result = new ArrayList<>();
            int i = 0, j = 0;
            while (i < a.size() && j < b.size()) {
                int compare = Integer.compare(a.get(i), b.get(j));
                if (compare == 1) j++;
                else if (compare == -1) i++;
                else {
                    result.add(a.get(i));
                    i++;j++;
                }
            }
            return result;
        }
    }
}
