// https://leetcode.com/problems/longest-palindrome/

// Solution: Frequency Count — O(n) time, O(1) space
class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        int length = 0;
        for (int count : freq) {
            length += (count / 2) * 2;
        }
        return length < s.length() ? length + 1 : length;
    }
}
