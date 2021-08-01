package bitmanipulation;

public class NumberOf1Bits {
    public class Solution {
        public int numSetBits(long a) {
            int count = 0;
            while (a != 0) {
                long rsb = (a & -a);
                a = a - rsb;
                count++;
            }
            return count;
        }
    }
}
