// https://leetcode.com/problems/license-key-formatting/

// Solution: Reverse Traversal — O(N) time, O(N) space
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder clean = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                clean.append(Character.toUpperCase(c));
            }
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < clean.length()) {
            if (result.length() > 0) {
                result.append('-');
            }
            int end = Math.min(i + k, clean.length());
            result.append(clean, i, end);
            i += k;
        }
        return result.reverse().toString();
    }
}
