// https://leetcode.com/problems/shifting-letters/

// Solution: Suffix Sum — O(n) time, O(n) space
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] chars = s.toCharArray();
        long total = 0;
        for (int i = n - 1; i >= 0; i--) {
            total = (total + shifts[i]) % 26;
            chars[i] = (char) ('a' + (chars[i] - 'a' + total) % 26);
        }
        return new String(chars);
    }
}
