package twopointers;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumZero {
    public class Solution {
        public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
            Collections.sort(A);
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = 0; i < A.size() - 2; i++) {
                if (i > 0 && Integer.compare(A.get(i), A.get(i - 1)) == 0) continue;
                int start = i + 1, end = A.size() - 1;
                while (start < end) {
                    long sum = (long)A.get(i) + (long)A.get(start) + (long)A.get(end);
                    if (sum == 0) {
                        ArrayList<Integer> temp = new ArrayList<> ();
                        temp.add(A.get(i));
                        temp.add(A.get(start));
                        temp.add(A.get(end));
                        result.add(temp);
                        start++;
                        end--;
                        while (start < end && Integer.compare(A.get(start), A.get(start - 1)) == 0) start++;
                        while (start < end && Integer.compare(A.get(end), A.get(end + 1)) == 0) end--;
                    } else if (sum > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
            return result;
        }
    }
}
