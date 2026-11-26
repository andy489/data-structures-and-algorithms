// https://leetcode.com/problems/apply-operations-to-make-string-empty/

// Solution: Frequency Analysis — O(n) time, O(n) space
class Solution {
    public String lastNonEmptyString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) { freq[c - 'a']++; }
        int maxFreq = 0;
        for (int f : freq) { maxFreq = Math.max(maxFreq, f); }
        boolean[] seen = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            if (freq[idx] == maxFreq && !seen[idx]) {
                sb.append(s.charAt(i));
                seen[idx] = true;
            }
        }
        return sb.reverse().toString();
    }
}
