package binarysearch;

public class ImplementPowerFunction {
    public class Solution {
        public int pow(int x, int n, int d) {
            if (x == 0) return 0;
            if (x == 1) return 1;
            if (n == 0) return 1;
            long y = 0, z = 0;
            if (n % 2 == 0) {
                z = pow(x, n / 2, d);
                y = ((z % d) * (z % d)) % d;
            } else {
                z = pow(x, n - 1, d);
                y = x;
                y = ((y % d) * (z % d)) % d;
            }
            long result = (y + d) % d;
            return (int) result;
        }
    }
}
