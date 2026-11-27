// https://leetcode.com/problems/valid-number/

// Solution: Linear scan with flags — O(n) time, O(1) space
class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false, seenDot = false, seenE = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                if (seenDot || seenE) return false;
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                if (seenE || !seenDigit) return false;
                seenE = true;
                seenDigit = false;
            } else if (c >= '0' && c <= '9') {
                seenDigit = true;
            } else {
                return false;
            }
        }
        return seenDigit;
    }
}
