// https://leetcode.com/problems/palindrome-rearrangement-queries/
class Solution {
    public boolean[] canMakePalindromeQueries(String s, int[][] queries) {
        int n = s.length();
        int half = n / 2;
        // prefix[i][c] = count of char c in s[0..i-1]
        int[][] prefL = new int[half + 1][26];
        int[][] prefR = new int[half + 1][26];
        for (int i = 0; i < half; i++) {
            prefL[i + 1] = prefL[i].clone();
            prefL[i + 1][s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < half; i++) {
            prefR[i + 1] = prefR[i].clone();
            prefR[i + 1][s.charAt(n - 1 - i) - 'a']++;
        }
        // mismatch[i] = 1 if s[i] != s[n-1-i], prefix sum for range queries
        int[] mismatch = new int[half + 1];
        for (int i = 0; i < half; i++) {
            mismatch[i + 1] = mismatch[i] + (s.charAt(i) != s.charAt(n - 1 - i) ? 1 : 0);
        }

        boolean[] result = new boolean[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int a = queries[q][0], b = queries[q][1];
            int c = queries[q][2], d = queries[q][3];
            // Reflect right range to left indices
            int cl = n - 1 - d, dl = n - 1 - c;
            int lo = Math.min(a, cl), hi = Math.max(b, dl);
            // Check mismatches outside [lo, hi]
            int outsideMismatch = mismatch[lo] + (mismatch[half] - mismatch[hi + 1]);
            if (outsideMismatch > 0) {
                result[q] = false;
                continue;
            }
            // Check character counts in union [lo, hi]
            // Positions only in left window [a,b] but not right window [cl,dl] and vice versa must match
            // The counts in [a,b] from left and [cl,dl] from right should jointly balance
            int[] cntL = rangeCount(prefL, a, b);
            int[] cntR = rangeCount(prefR, cl, dl);
            // Extra characters in left window [a,b] not covered by right [cl,dl]
            // and vice versa
            boolean ok = true;
            for (int ch = 0; ch < 26; ch++) {
                if (cntL[ch] != cntR[ch]) {
                    ok = false;
                    break;
                }
            }
            result[q] = ok;
        }
        return result;
    }

    private int[] rangeCount(int[][] pref, int l, int r) {
        int[] cnt = new int[26];
        for (int c = 0; c < 26; c++) {
            cnt[c] = pref[r + 1][c] - pref[l][c];
        }
        return cnt;
    }
}
