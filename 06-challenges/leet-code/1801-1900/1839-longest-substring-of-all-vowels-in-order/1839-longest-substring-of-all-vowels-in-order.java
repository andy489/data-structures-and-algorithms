// https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int longestBeautifulSubstring(String word) {
        String vowels = "aeiou";
        int n = word.length();
        int ans = 0, start = 0, distinct = 1;
        for (int i = 1; i < n; i++) {
            int cur = vowels.indexOf(word.charAt(i));
            int prev = vowels.indexOf(word.charAt(i - 1));
            if (cur == prev) {
                // same vowel, extend
            } else if (cur == prev + 1) {
                distinct++;
            } else {
                start = i;
                distinct = 1;
            }
            if (distinct == 5) {
                ans = Math.max(ans, i - start + 1);
            }
        }
        return ans;
    }
}
