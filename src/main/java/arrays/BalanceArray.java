package arrays;

public class BalanceArray {
    public class Solution {
        public int solve(int[] A) {
            int oddsum = 0, evensum = 0;
            for (int i = 0; i < A.length; i++) {
                if (i % 2 == 0) {
                    evensum += A[i];
                } else {
                    oddsum += A[i];
                }
            }
            int tevensum = 0;
            int toddsum = 0;
            int count = 0;
            for (int i = 0; i < A.length; i++) {
                if (i % 2 == 0) {
                    if ((tevensum + oddsum - toddsum) == (toddsum + evensum - tevensum - A[i])) count++;
                    tevensum += A[i];
                } else {
                    if ((tevensum + oddsum - toddsum - A[i]) == (toddsum + evensum - tevensum)) count++;
                    toddsum += A[i];
                }
            }
            return count;
        }
    }
}
