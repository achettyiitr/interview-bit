package math;

import java.util.Arrays;

public class NextSimilarNumber {
    public class Solution {
        public String solve(String A) {
            int n = A.length();
            char arr[] = A.toCharArray();
            int i = n - 2;
            while (i >= 0 && arr[i] >= arr[i + 1]) i--;
            if (i == -1) return "-1";
            int j = n - 1;
            while (j > i && arr[j] <= arr[i]) j--;
            swap(arr, i, j);
            Arrays.sort(arr, i + 1, n);
            return new String(arr);
        }

        private void swap(char[] arr, int i, int j) {
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
        }
    }
}
