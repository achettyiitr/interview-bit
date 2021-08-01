package dynamicprogramming;

public class MergeElements {
    public class Solution {
        public int solve(int[] A) {
            int n = A.length;
            if (n == 0 || n == 1) {
                return 0;
            }
            int dpME[] = new int[n];
            int dpMS[] = new int[n];
            dpME[0] = A[0];
            dpMS[0] = A[0];
            dpME[1] = A[0] + A[1];
            dpMS[1] = A[0] + A[1];
            for (int i = 2; i < n; i++) {
                int newELe1 = A[i] + dpME[i - 1];
                int newELe2 = A[i] + A[i - 1] + dpME[i - 2];
                int cost1 = dpMS[i - 1] + newELe1;
                int cost2 = dpMS[i - 2] + newELe2 + A[i] + A[i - 1];
                if (cost1 > cost2 || (cost1 == cost2 && newELe1 > newELe2)) {
                    dpME[i] = newELe2;
                    dpMS[i] = cost2;
                } else {
                    dpME[i] = newELe1;
                    dpMS[i] = cost1;
                }
            }
            //    System.out.println(Arrays.toString(dpME));
            //    System.out.println(Arrays.toString(dpMS));
            return dpMS[n - 1];
        }
    }
}
