package arrays;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateInArray {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int repeatedNumber(final int[] A) {
            Set<Integer> set = new HashSet<>();
            for (int i: A) {
                if (set.contains(i)) {
                    return i;
                } else {
                    set.add(i);
                }
            }
            return -1;
        }
    }
}
