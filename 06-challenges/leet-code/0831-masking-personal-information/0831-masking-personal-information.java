// https://leetcode.com/problems/masking-personal-information/

// Solution: String Parsing — O(n) time, O(n) space
class Solution {
    public String maskPII(String s) {
        s = s.toLowerCase();
        int at = s.indexOf('@');
        if (at >= 0) {
            return s.charAt(0) + "*****" + s.substring(at - 1);
        }
        StringBuilder digits = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }
        String last4 = digits.substring(digits.length() - 4);
        String prefix = "***-***-";
        int extra = digits.length() - 10;
        if (extra == 1) {
            prefix = "+*-" + prefix;
        } else if (extra == 2) {
            prefix = "+**-" + prefix;
        } else if (extra == 3) {
            prefix = "+***-" + prefix;
        }
        return prefix + last4;
    }
}
