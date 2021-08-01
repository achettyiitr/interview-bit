package bitmanipulation;

public class SingleNumber {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int singleNumber(final int[] A) {
            long xor = 0;
            for (int i: A) xor ^= i;
            return (int) xor;
        }
    }
}
