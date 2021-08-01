package backtracking;

import java.math.BigInteger;
import java.util.ArrayList;

public class KthPermutationSequence {
    public class Solution {
        public String getPermutation(int n, int pos) {
            BigInteger A = BigInteger.valueOf(n);
            BigInteger B = BigInteger.valueOf(pos);
            BigInteger total = BigInteger.ONE;
            int count = 1;
            ArrayList<Integer> nums = new ArrayList<>();
            while (count < n) {
                nums.add(count);
                total = total.multiply(BigInteger.valueOf(count));
                count += 1;
            }
            nums.add(count);
            B = B.subtract(BigInteger.ONE);

            StringBuilder sb = new StringBuilder("");
            while (true) {
                int index = B.divide(total).intValue();
                sb.append(nums.get(index));
                nums.remove(index);

                if (nums.isEmpty()) break;

                B = B.mod(total);
                total = total.divide(BigInteger.valueOf(nums.size()));
            }
            return sb.toString();
        }
    }

}
