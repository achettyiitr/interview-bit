package binarysearch;

public class SearchInBitonicArray {
    public class Solution {
        public int solve(int[] A, int B) {
            int n = A.length;
            int pivot = pivot(A);
            if (pivot == -1) return binarySearch(A, 0, n - 1, B, true);
            int left = binarySearch(A, 0, pivot, B, true);
            if (left == -1) return binarySearch(A, pivot, n - 1, B, false);
            else return left;
        }

        private int binarySearch(int[] arr, int left, int right, int key, boolean isIncreasing) {
            if (left > right) return -1;
            int mid = left + (right - left) / 2;

            if (isIncreasing) {
                if (arr[mid] == key) return mid;
                else if (arr[mid] > key) {
                    return binarySearch(arr, left, mid - 1, key, isIncreasing);
                } else {
                    return binarySearch(arr, mid + 1, right, key, isIncreasing);
                }
            } else {
                if (arr[mid] == key) return mid;
                else if (arr[mid] < key) {
                    return binarySearch(arr, left, mid - 1, key, isIncreasing);
                } else {
                    return binarySearch(arr, mid + 1, right, key, isIncreasing);
                }
            }
        }

        private int pivot(int[] A) {
            int start = 0, end = A.length - 1;
            while (start <= end) {
                if (start == end) return start;
                int mid = start + (end - start) / 2;

                if ((mid == start || A[mid] > A[mid - 1]) && (mid == end || A[mid] > A[mid + 1])) {
                    return mid;
                } else if ((mid == start || A[mid] > A[mid - 1]) && (mid == end || A[mid] < A[mid + 1])) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return -1;
        }
    }
}
