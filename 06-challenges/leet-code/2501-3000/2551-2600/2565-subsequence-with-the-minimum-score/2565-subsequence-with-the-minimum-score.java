// https://leetcode.com/problems/subsequence-with-the-minimum-score/

// Solution: Prefix + Suffix Matching — O((n+m) log m) time, O(n+m) space
class Solution {
    public int minimumScore(String s, String t) {
        int n = s.length(), m = t.length();
        // pre[i] = number of t chars matched using s[0..i] (prefix of t)
        int[] pre = new int[n];
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            pre[i] = j;
        }
        for (int i = j == 0 ? 0 : n - 1; i < n; i++) {
            if (j < pre.length) {
                pre[i] = j;
            }
        }
        // Fill pre fully
        j = 0;
        for (int i = 0; i < n; i++) {
            if (j < m && s.charAt(i) == t.charAt(j)) {
                j++;
            }
            pre[i] = j;
        }
        // suf[i] = number of t chars matched using s[i..n-1] (suffix of t)
        int[] suf = new int[n];
        j = m - 1;
        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (s.charAt(i) == t.charAt(j)) {
                j--;
            }
            suf[i] = m - 1 - j;
        }
        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && s.charAt(i) == t.charAt(j)) {
                j--;
            }
            suf[i] = m - 1 - j;
        }
        // If t is already a subsequence of s
        if (pre[n - 1] == m) {
            return 0;
        }
        // Try removing window [l, r] from t
        // pre[i] = how many chars from t's start we can match using s[0..i]
        // suf[i] = how many chars from t's end we can match using s[i..n-1]
        // For a split at s position i: left part covers pre[i] chars, right part covers suf[i+1] chars
        // We need pre[i] + suf[i+1] >= m, removed chars = m - pre[i] - suf[i+1]
        // Window size = right - left + 1 = m - pre[i] - suf[i+1] (or 0 if negative)
        int ans = m; // worst case: remove all of t
        for (int i = -1; i < n; i++) {
            int prefixMatched = i >= 0 ? pre[i] : 0;
            int suffixMatched = i + 1 < n ? suf[i + 1] : 0;
            int removed = m - prefixMatched - suffixMatched;
            ans = Math.min(ans, Math.max(0, removed));
        }
        return ans;
    }
}
