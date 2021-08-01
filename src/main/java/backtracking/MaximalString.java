package backtracking;

public class MaximalString {
    public class Solution {
        private String ans = "";
        public String solve(String A, int B) {
            solveUtil(A.toCharArray(), B);
            return ans;
        }

        private void solveUtil(char[] arr, int B) {
            if (B == 0) {
                String nans = new String(arr);
                if (ans.length() == 0 || Integer.parseInt(nans) > Integer.parseInt(ans)) {
                    ans = nans;
                }
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > arr[i]) {
                        swap(arr, i, j);
                        solveUtil(arr, B - 1);
                        swap(arr, i, j);
                    }
                }
            }
        }

        private void swap(char[] arr, int i, int j) {
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
        }
    }
}
