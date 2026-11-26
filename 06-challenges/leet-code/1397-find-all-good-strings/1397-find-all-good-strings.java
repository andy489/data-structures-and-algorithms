// https://leetcode.com/problems/find-all-good-strings/

// Solution: Digit DP + KMP — O(n * m * 26) time, O(n * m) space
class Solution {
    static final int MOD = 1_000_000_007;
    int n, m;
    int[] fail;
    String s1, s2, evil;
    int[][][][] memo;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        this.n = n; this.s1 = s1; this.s2 = s2; this.evil = evil;
        m = evil.length();
        fail = new int[m];
        for (int i = 1; i < m; i++) {
            int j = fail[i-1];
            while (j > 0 && evil.charAt(i) != evil.charAt(j)) j = fail[j-1];
            if (evil.charAt(i) == evil.charAt(j)) j++;
            fail[i] = j;
        }
        memo = new int[n][m][2][2];
        for (int[][][] a : memo) for (int[][] b : a) for (int[] c : b) Arrays.fill(c, -1);
        return dp(0, 0, true, true);
    }

    private int dp(int pos, int kmpState, boolean tightL, boolean tightR) {
        if (kmpState == m) return 0;
        if (pos == n) return 1;
        int ti = tightL ? 1 : 0, tj = tightR ? 1 : 0;
        if (memo[pos][kmpState][ti][tj] != -1) return memo[pos][kmpState][ti][tj];
        int lo = tightL ? s1.charAt(pos) : 'a';
        int hi = tightR ? s2.charAt(pos) : 'z';
        long res = 0;
        for (char c = (char)lo; c <= (char)hi; c++) {
            int nk = kmpState;
            while (nk > 0 && evil.charAt(nk) != c) nk = fail[nk-1];
            if (evil.charAt(nk) == c) nk++;
            if (nk == m) continue;
            res = (res + dp(pos+1, nk, tightL && c==s1.charAt(pos), tightR && c==s2.charAt(pos))) % MOD;
        }
        return memo[pos][kmpState][ti][tj] = (int)res;
    }
}
