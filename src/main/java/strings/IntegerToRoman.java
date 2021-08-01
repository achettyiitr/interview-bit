package strings;

public class IntegerToRoman {
    public class Solution {
        public String intToRoman(int A) {
            String[] thousands = new String[] {"", "M", "MM", "MMM"};
            String[] hundreds = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            String[] tens = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String[] ones = new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            return thousands[A/1000] + hundreds[(A%1000)/100] + tens[(A%100)/10] + ones[(A%10)];
        }
    }
}
