package arrays;

public class RepeatAndMissingNumberArray {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int[] repeatedNumber(final int[] A) {
            int r[] = new int[2];
            int xor = 0;
            for (int i : A) xor ^=  i;
            for (int i = 1; i <= A.length; i++) xor ^= i;

            int rmb = xor & -xor, one = 0, two = 0;
            for (int i : A) {
                if ((i & rmb) > 0) {
                    one ^= i;
                } else {
                    two ^= i;
                }
            }
            for (int i = 1; i <= A.length; i++) {
                if ((i & rmb) > 0) {
                    one ^= i;
                } else {
                    two ^= i;
                }
            }
            int count = 0;
            for (int i: A) {
                if (i == one) count++;
            }
            if (count == 0) {
                int temp = one;
                one = two;
                two = temp;
            }
            r[0] = one;
            r[1] = two;
            return r;
        }
    }
}
