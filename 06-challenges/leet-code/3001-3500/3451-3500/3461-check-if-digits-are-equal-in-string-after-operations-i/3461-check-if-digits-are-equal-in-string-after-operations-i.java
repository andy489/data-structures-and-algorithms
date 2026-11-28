// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/

// Solution: Simulation — O(n^2) time, O(n) space
class Solution {
    public boolean hasSameDigits(String s) {
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        while (digits.length > 2) {
            int[] next = new int[digits.length - 1];
            for (int i = 0; i < next.length; i++) {
                next[i] = (digits[i] + digits[i + 1]) % 10;
            }
            digits = next;
        }
        return digits[0] == digits[1];
    }
}
