package binarysearch;

public class AllocateBooks {
    public class Solution {
        public int books(int[] A, int B) {
            if (A.length < B) return -1;
            int sum = 0;
            for (int i: A) sum += i;
            int start = 0, end = sum, ans = -1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (isValidBooKAllotment(A, B, mid)) {
                    ans = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return ans;
        }

        private boolean isValidBooKAllotment(int[] A, int B, int k) {
            int sum = 0, count = 1;
            for (int i: A) {
                if (i > k) return false;
                sum += i;
                if (sum > k) {
                    count++;
                    sum = i;
                } else {
                    continue;
                }
            }
            return (count > B) ? false : true;
        }
    }
}
