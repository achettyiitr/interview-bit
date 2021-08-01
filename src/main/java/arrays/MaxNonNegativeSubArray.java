package arrays;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {
    public class Solution {
        public ArrayList<Integer> maxset(ArrayList<Integer> A) {
            int n = A.size(), endIndex = -1, maxLength = 0, currLength = 0;
            long mssf = 0;
            long meh = 0;
            for (int i = 0; i < n; i++) {
                if (A.get(i) < 0) {
                    mssf = 0;
                    currLength = 0;
                } else {
                    mssf = mssf + A.get(i);
                    currLength++;
                }
                if (meh < mssf) {
                    meh = mssf;
                    endIndex = i;
                    maxLength = currLength;
                } else if (meh == mssf) {
                    if (currLength > maxLength) {
                        maxLength = currLength;
                        endIndex = i;
                    }
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            if (endIndex != -1) {
                for (int i = endIndex - maxLength + 1; i <= endIndex; i++) {
                    result.add(A.get(i));
                }
            }
            return result;
        }
    }
}
