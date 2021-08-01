package math;

import java.util.ArrayList;

public class MATH_BUG02 {
    public class Solution {
        public ArrayList<ArrayList<Integer>> squareSum(int A) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

            for (int a = 0; a * a < A; a++) {
                for (int b = a; b * b < A; b++) {
                    if (a * a + b * b == A) {
                        ArrayList<Integer> newEntry = new ArrayList<Integer>();
                        newEntry.add(a);
                        newEntry.add(b);
                        ans.add(newEntry);
                    }
                }
            }
            return ans;
        }
    }
}
