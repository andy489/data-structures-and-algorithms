// https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/
class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char p0 = pattern.charAt(0);
        char p1 = pattern.charAt(1);
        long base = 0;
        long countP0 = 0;
        long countP1 = 0;
        for (char c : text.toCharArray()) {
            if (c == p1) {
                base += countP0;
                countP1++;
            }
            if (c == p0) {
                countP0++;
            }
        }
        return base + Math.max(countP0, countP1);
    }
}
