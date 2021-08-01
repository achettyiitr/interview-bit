package binarysearch;

public class MatrixSearch {
    public class Solution {
        public int searchMatrix(int[][] A, int B) {
            int m = A.length, n = A[0].length;
            int start = 0, end = m * n - 1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                int x = mid / n;
                int y = mid % n;
                if (A[x][y] == B) {
                    return 1;
                } else if (A[x][y] > B) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return 0;
        }
    }
}
