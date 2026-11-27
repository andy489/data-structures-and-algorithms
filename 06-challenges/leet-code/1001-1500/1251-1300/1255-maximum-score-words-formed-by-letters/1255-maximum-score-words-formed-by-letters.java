// https://leetcode.com/problems/maximum-score-words-formed-by-letters/

// Solution: Bitmask Enumeration — O(2^n * L) time, O(26) space
// Solution: Bitmask Enumeration — O(2^n * L) time, O(26) space
class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] avail = new int[26];
        for (char c : letters) avail[c - 'a']++;
        int n = words.length, res = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int[] need = new int[26];
            int s = 0;
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 0) continue;
                for (char c : words[i].toCharArray()) { need[c - 'a']++; s += score[c - 'a']; }
            }
            for (int i = 0; i < 26; i++) if (need[i] > avail[i]) { ok = false; break; }
            if (ok) res = Math.max(res, s);
        }
        return res;
    }
}
