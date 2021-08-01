package math;

public class SortedPermutationRank {
    public class Solution {
        public int findRank(String A) {
            int n = A.length();
            int[] ndc = new int[n];
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = i + 1; j < n; j++) {
                    if (A.charAt(j) < A.charAt(i)) count++;
                }
                ndc[i] = count;
            }
            long r = 0;
            long m = 1000003;
            long a = 0;
            for (int i = 0; i < n; i++) {
                a = (ndc[i] % m * factorial(n - 1 - i) % m) % m;
                r = (r % m + a % m) % m;
            }
            r += 1;
            return (int)r;
        }

        private long factorial(int n) {
            long r = 1;
            long m = 1000003;
            for (int i = 2; i <= n; i++) {
                r = (r % m * i % m) % m;
            }
            return r;
        }
    }
}
