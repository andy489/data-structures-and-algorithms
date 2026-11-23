// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

// Solution: Divide and Conquer — O(n * 26) time, O(26 * log n) space
class Solution {
    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length() - 1, k);
    }

    private int solve(String s, int l, int r, int k) {
        if (r - l + 1 < k) {
            return 0;
        }
        int[] freq = new int[26];
        for (int i = l; i <= r; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = l; i <= r; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                return Math.max(solve(s, l, i - 1, k), solve(s, i + 1, r, k));
            }
        }
        return r - l + 1;
    }
}
