package backtracking;

public class ModularExpression {
    public class Solution {
        public int Mod(int A, int B, int C) {
            if (A == 0) return 0;
            if (A == 1) return 1;
            if (B == 0) return 1;

            long x = 0, y = 0;
            if (B % 2 == 0) {
                x = Mod(A, B /2, C);
                y = (x%C * x%C) % C;
            } else {
                x = Mod(A, B - 1, C);
                y = (A%C * x%C) % C;
            }
            return (int)((y + C) %C);
        }
    }
}
