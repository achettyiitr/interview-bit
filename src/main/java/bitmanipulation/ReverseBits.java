package bitmanipulation;

public class ReverseBits {
    public class Solution {
        public long reverse(long a) {
            long result = 0L;
            for (int i = 31; i >= 0; i--) {
                long bit = ((1 << (31 - i)) & a) > 0 ? 1 : 0;
                result |= bit << i;
            }
            return result;
        }
    }
}
