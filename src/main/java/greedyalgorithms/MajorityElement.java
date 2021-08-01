package greedyalgorithms;

public class MajorityElement {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int majorityElement(final int[] A) {
            int count = 1, element = A[0], n = A.length;
            for (int i = 1; i < n; i++) {
                if (A[i] == element) {
                    count++;
                } else {
                    count--;
                }
                if (count == 0) {
                    element = A[i];
                    count = 1;
                }
            }
            count = 0;
            for (int i = 0; i < n; i++) {
                if (A[i] == element) count++;
            }
            int check = (int)Math.floor(((double) n)/ ((double) 2));
            if (count > check) {
                return element;
            } else {
                return -1;
            }
        }
    }
}
