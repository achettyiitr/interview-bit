package dynamicprogramming;

public class Stairs {
    public class Solution {
        public int climbStairs(int A) {
            if (A == 0) return 1;
            if (A < 0) return 0;
            return climbStairs(A - 1) + climbStairs(A - 2);
        }
    }
}
