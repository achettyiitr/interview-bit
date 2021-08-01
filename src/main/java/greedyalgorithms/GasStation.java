package greedyalgorithms;

public class GasStation {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int canCompleteCircuit(final int[] A, final int[] B) {
            int n = A.length;
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                if (A[0] < B[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
            int start = 0, end = 1, currentPetrol = A[0] - B[0];
            while (start != end || currentPetrol < 0) {
                while (start != end && currentPetrol < 0) {
                    currentPetrol -= A[start] - B[start];
                    start = (start + 1) % n;
                    if (start == 0) {
                        return -1;
                    }
                }
                currentPetrol += A[end] - B[end];
                end = (end + 1)% n;
            }
            return start;
        }
    }
}
