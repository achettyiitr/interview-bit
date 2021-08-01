package arrays;

public class Partitions {
    public class Solution {
        public int solve(int n, int[] A) {
            int sum = 0, c = 0;
            for (int i: A) sum += i;
            if (sum % 3 != 0) return 0;
            int x1sum = 0, x2sum = 0, psum = sum / 3;
            for (int i = 0; i <= n - 3; i++) {
                x1sum += A[i];
                if (x1sum == psum) {
                    x2sum = 0;
                    for (int j = i + 1; j <= n - 2; j++) {
                        x2sum += A[j];
                        if (x2sum == psum) {
                            c++;
                        }
                    }
                }
            }
            return c;
        }
    }
}
