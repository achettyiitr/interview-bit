package arrays;

public class AddOneToNumber {
    public class Solution {
        public int[] plusOne(int[] A) {
            int n = A.length, c = 0;
            A[n - 1] += 1;
            c = A[n - 1] / 10;
            A[n - 1] %= 10;

            for (int i = n - 2; i >= 0; i--) {
                if (c == 1) {
                    A[i] += c;
                    c = A[i] / 10;
                    A[i] %= 10;
                } else {
                    break;
                }
            }
            if (c == 1) {
                A = appendCarryToFront(A);
            }
            return truncateZeroesFromFront(A);
        }

        private int[] appendCarryToFront(int[] A) {
            int nA[] = new int[A.length + 1];
            nA[0] = 1;
            for (int i = 1; i < nA.length; i++) {
                nA[i] = A[i - 1];
            }
            return nA;
        }

        private int[] truncateZeroesFromFront(int[] A) {
            int i = 0;
            while (i < A.length && A[i] == 0) i++;

            int nA[] = new int[A.length - i];
            int j = 0;
            while (j < nA.length) {
                nA[j++] = A[i++];
            }
            return nA;
        }
    }
}
