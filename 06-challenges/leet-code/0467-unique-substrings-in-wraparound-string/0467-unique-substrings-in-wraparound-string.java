// https://leetcode.com/problems/unique-substrings-in-wraparound-string/

// Solution: DP — O(n) time, O(1) space
class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] maxLenEndingAt = new int[26];
        int curLen = 0;
        for (int i = 0; i < p.length(); i++) {
            int ch = p.charAt(i) - 'a';
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                curLen++;
            } else {
                curLen = 1;
            }
            if (curLen > maxLenEndingAt[ch]) {
                maxLenEndingAt[ch] = curLen;
            }
        }
        int total = 0;
        for (int count : maxLenEndingAt) {
            total += count;
        }
        return total;
    }
}
