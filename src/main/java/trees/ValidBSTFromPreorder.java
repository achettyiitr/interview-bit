package trees;

public class ValidBSTFromPreorder {
    public class Solution {
        public int solve(int[] A) {
            if (validBSFForPreOrder(A, 0, A.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                return 1;
            } else {
                return 0;
            }
        }

        private boolean validBSFForPreOrder(int[] A, int start, int end, int min, int max) {
            if (start > end) {
                return true;
            }
            if (A[start] < min || A[start] > max) return false;
            int rightIndex = -1;
            for (int i = start + 1; i <= end; i++) {
                if (A[i] > A[start]) {
                    rightIndex = i;
                    break;
                }
            }
            if (rightIndex != -1) {
                boolean isLeftValid = validBSFForPreOrder(A, start + 1, rightIndex - 1, min, A[start]);
                boolean isRightvalid = validBSFForPreOrder(A, rightIndex, end, A[start], max);
                return isLeftValid && isRightvalid;
            } else {
                boolean isLeftValid = validBSFForPreOrder(A, start + 1, end, min, A[start]);
                return isLeftValid;
            }
        }
    }
}
