package arrays;

public class MaximumAbsoluteDifference {
    public class Solution {
        public int maxArr(int[] A) {
            int maxAiplusi = Integer.MIN_VALUE;
            int minAiplusi = Integer.MAX_VALUE;
            int maxAiminusi = Integer.MIN_VALUE;
            int minAiminusi = Integer.MAX_VALUE;
            for (int i = 0; i < A.length; i++) {
                maxAiplusi = Math.max(maxAiplusi, A[i] + i);
                minAiplusi = Math.min(minAiplusi, A[i] + i);
                maxAiminusi = Math.max(maxAiminusi, A[i] - i);
                minAiminusi = Math.min(minAiminusi, A[i] - i);
            }
            return Math.max(maxAiplusi - minAiplusi, maxAiminusi - minAiminusi);
        }
    }
}
