package arrays;

public class FirstMissingInteger {
    public class Solution {
        public int firstMissingPositive(int[] A) {
            int n = A.length;
            for (int i = 0; i < A.length;) {
                if (A[i] > n || A[i] < 1) {
                    i++;
                    continue;
                } else {
                    if (A[i] != A[A[i] - 1]) {
                        swap(A, i, A[i] - 1);
                    } else {
                        i++;
                    }
                }
            }
            for (int i = 0; i < A.length; i++) {
                if (A[i] != i + 1) return i + 1;
            }
            return n + 1;
        }

        private void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
