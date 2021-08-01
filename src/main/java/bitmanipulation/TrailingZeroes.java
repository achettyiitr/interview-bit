package bitmanipulation;

public class TrailingZeroes {
    public class Solution {
        public int solve(int A) {
            int rsb = (A & -A), pos = 0;
            while (rsb != 0) {
                pos++;
                rsb = rsb >> 1;
            }
            return pos - 1;
        }
    }
}
