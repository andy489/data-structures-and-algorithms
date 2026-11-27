// https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/

// Solution: Combinatorics (Stars and Bars) — O(n*k) time, O(n*k) space
class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        // Answer is C(n + k - 1, 2k)
        int total = n + k - 1;
        int r = 2 * k;
        long[][] C = new long[total + 1][r + 1];
        for (int i = 0; i <= total; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= Math.min(i, r); j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
        return (int) C[total][r];
    }
}
