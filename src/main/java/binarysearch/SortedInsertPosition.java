package binarysearch;

import java.util.ArrayList;

public class SortedInsertPosition {
    public class Solution {
        public int searchInsert(ArrayList<Integer> a, int b) {
            int start = 0, end = a.size() - 1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                int val = a.get(mid);
                if (val == b) {
                    return mid;
                } else if (val > b) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }
    }
}
