package bitmanipulation;

public class SingleNumberII {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int singleNumber(final int[] A) {
            int tn = Integer.MAX_VALUE, tn1 = 0, tn2 = 0;
            for (int i: A) {
                int cmn = tn & i;
                int cmn1 = tn1 & i;
                int cmn2 = tn2 & i;

                tn1 ^= cmn;
                tn &= ~cmn;
                tn2 ^= cmn1;
                tn1 &= ~cmn1;
                tn ^= cmn2;
                tn2 &= ~cmn2;
            }
            return tn1;
        }
    }
}
