package math;

public class Reverseinteger {
    public class Solution {
        public int reverse(int A) {
            int i = 0, R = Math.abs(A), ld = 0, lv = 0;
            int sign = (A > 0) ? 1 : -1;
            while (R != 0) {
                ld = R % 10;
                i *= 10;
                i += ld;
                //System.out.print("i: " + i + " lv: " + lv + " ");
                if (((i - ld) / 10 ) != lv) return 0;
                R /= 10;
                lv = i;
            }
            return (int)i * sign;
        }
    }
}
