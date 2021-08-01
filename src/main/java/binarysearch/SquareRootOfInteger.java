package binarysearch;

public class SquareRootOfInteger {
    public class Solution {
        public int sqrt(int A) {
            long start = 0, end = A, ans = 0;
            while (start <= end) {
                long mid = (start + end) >> 1;
                long square = mid * mid;
                if (square < A) {
                    ans = mid;
                    start = mid + 1;
                } else if (square > A) {
                    end = mid - 1;
                } else {
                    return (int)mid;
                }
            }
            return (int)ans;
        }
    }
}
