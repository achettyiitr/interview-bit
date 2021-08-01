package strings;

import java.math.BigInteger;

public class PowerOf2 {
    public class Solution {
        public int power(String A) {
            BigInteger bi = new BigInteger(A);
            if (bi.compareTo(BigInteger.ONE) == 0) return 0;
            int bitcount = bi.bitCount();
            if (bitcount == 1) return 1;
            else return 0;
        }
    }
}
