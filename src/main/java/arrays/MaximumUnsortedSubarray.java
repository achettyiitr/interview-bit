package arrays;

public class MaximumUnsortedSubarray {
    public class Solution {
        public int[] subUnsort(int[] A) {
            int n = A.length, s = 0, e = n - 1;
            while (s < n - 1 && A[s] <= A[s + 1]) s++;
            while (e > 0 && A[e] >= A[e - 1]) e--;
            if (s == n - 1 || e == 0) {
                return new int[] {-1};
            }
            int min = s, max = e;
            for (int i = s; i <= e; i++) {
                if (A[i] < A[min]) {
                    min = i;
                }
                if (A[i] > A[max]) {
                    max = i;
                }
            }
            int i1 = s - 1, i2 = e + 1;
            while (i1 >= 0) {
                if (A[i1] > A[min]) i1--;
                else break;
            }
            while (i2 < n) {
                if (A[i2] < A[max]) i2++;
                else break;
            }
            return new int[]{i1 + 1, i2 - 1};
        }
    }
}
