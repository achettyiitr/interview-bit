package bitmanipulation;

public class PalindromicBinaryRepresentation {
    public class Solution {
        public int solve(int A) {
            int count = 0, level = 0, position = 0;
            while (count < A) {
                level++;
                count += (1 << ((level - 1) / 2));
            }
            count -= 1 << ((level - 1) / 2);
            position = A - count - 1;
            int result = (1 << (level - 1));
            result |= position << (level / 2);
            result |= reverseBits(result >> (level / 2));
            return result;
        }

        private int reverseBits(int i) {
            int result = 0;
            while (i != 0) {
                result <<= 1;
                result |= (i & 1);
                i = i >> 1;
            }
            return result;
        }
    }
}
