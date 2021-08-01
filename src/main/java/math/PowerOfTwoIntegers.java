package math;

public class PowerOfTwoIntegers {
    public class Solution {
        public int isPower(int A) {
            if (A == 1) return 1;
            for (int i = 2; i * i <= A; i++) {
                double power = Math.log(A)/ Math.log(i);
                if ((power - (int)power) < 0.00000001) return 1;
            }
            return 0;
        }
    }
}
