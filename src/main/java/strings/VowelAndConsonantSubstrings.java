package strings;

public class VowelAndConsonantSubstrings {
    public class Solution {
        public int solve(String A) {
            int mod = 1000000007;
            int startWithVowels = startWithVowelsAndEndsWithVowels(A);
            int startWithConsonents = startWithConsonentsAndEndsWithConsonents(A);
            return ((startWithVowels % mod) + (startWithConsonents % mod)) % mod;
        }

        private int startWithConsonentsAndEndsWithConsonents(String A) {
            int count = 0, mod = 1000000007, result = 0;
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                if (!isVowel(ch)) {
                    count++;
                } else {
                    result = (result % mod + count % mod) % mod;
                }
            }
            return result;
        }

        private int startWithVowelsAndEndsWithVowels(String A) {
            int count = 0, mod = 1000000007, result = 0;
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                if (isVowel(ch)) {
                    count++;
                } else {
                    result = (result % mod + count % mod) % mod;
                }
            }
            return result;
        }

        private boolean isVowel(char ch) {
            switch(ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': {
                    return true;
                }
            }
            return false;
        }
    }
}
