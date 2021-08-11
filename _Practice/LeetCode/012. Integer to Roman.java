// https://leetcode.com/problems/integer-to-roman/
// Time: O(log10(num))

class Solution {
    public String intToRoman(int num) {
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] numerals = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (int i = 12; i >= 0; ) {
                int x = num / numerals[i];
                while (x > 0) {
                    sb.append(romans[i]);
                    x--;
                }
                num %= numerals[i--];
            }
        }
        return sb.toString();
    }
}
