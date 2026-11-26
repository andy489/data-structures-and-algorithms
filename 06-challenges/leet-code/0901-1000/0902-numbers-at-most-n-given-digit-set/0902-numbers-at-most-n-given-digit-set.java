// https://leetcode.com/problems/numbers-at-most-n-given-digit-set/

// Solution: Digit DP / Math — O(log n * d) time, O(log n) space
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = Integer.toString(n);
        int L = s.length(), d = digits.length;
        int result = 0;
        for (int len = 1; len < L; len++) {
            int pow = 1;
            for (int i = 0; i < len; i++) {
                pow *= d;
            }
            result += pow;
        }
        for (int i = 0; i < L; i++) {
            int strictlyLess = 0;
            for (String digit : digits) {
                if (digit.charAt(0) < s.charAt(i)) {
                    strictlyLess++;
                }
            }
            int pow = 1;
            for (int j = i + 1; j < L; j++) {
                pow *= d;
            }
            result += strictlyLess * pow;
            boolean found = false;
            for (String digit : digits) {
                if (digit.charAt(0) == s.charAt(i)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return result;
            }
        }
        return result + 1;
    }
}
