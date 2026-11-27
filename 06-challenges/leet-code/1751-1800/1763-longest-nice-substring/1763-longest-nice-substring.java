// https://leetcode.com/problems/longest-nice-substring/

// Solution: Divide and Conquer — O(n^2) time, O(n) space
class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char other = Character.isUpperCase(c)
                    ? Character.toLowerCase(c)
                    : Character.toUpperCase(c);
            if (s.indexOf(other) < 0) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }
        return s;
    }
}
