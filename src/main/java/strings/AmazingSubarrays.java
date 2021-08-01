package strings;

public class AmazingSubarrays {
    public class Solution {
        public int solve(String A) {
            int count = 0, result = 0, mod = 10003;
            int i = 0;
            while (i < A.length()) {
                char ch = A.charAt(i);
                switch (ch) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U': {
                        count++;
                    }
                }
                i++;
                result = ((result % mod) + (count % mod)) % mod;
            }
            return result;
        }
    }
}
