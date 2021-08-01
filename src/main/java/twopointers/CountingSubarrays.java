package twopointers;

public class CountingSubarrays {
    public class Solution {
        public int solve(int[] A, int B) {
            int n = A.length, start = 0,  end = 0, result = 0, count = 0, sum = 0;;
            while (end < n) {
                if (A[end] >= B) {
                    count = 0;
                    sum = 0;
                    start = end + 1;
                } else {
                    sum += A[end];
                    if (sum >= B) {
                        while (sum >= B) {
                            count--;
                            sum -= A[start];
                            start++;
                        }
                    }
                    count++;
                    result += count;
                }
                end++;
            }
            return result;
        }
    }
}
