// https://leetcode.com/problems/count-k-reducible-numbers-less-than-n/

// Solution: Digit DP + Popcount Reduction Check — O(n^2) time, O(n^2) space
class Solution {
    public int countKReducibleNumbers(String s, int k) {
        final int MOD = 1_000_000_007;
        int n = s.length();

        // Precompute binomial coefficients C[i][j] mod MOD
        long[][] C = new long[n + 1][n + 1];
        C[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        // steps[c] = number of popcount ops to reduce c to 1 (steps[1]=0)
        int[] steps = new int[n + 1];
        steps[1] = 0;
        for (int c = 2; c <= n; c++) {
            steps[c] = 1 + steps[Integer.bitCount(c)];
        }

        long ans = 0;
        // For each valid set-bit count c (1-reducible means steps[c] < k)
        for (int c = 1; c <= n; c++) {
            if (steps[c] >= k) {
                continue;
            }
            // Count numbers with exactly c set bits that are strictly < n (binary = s)
            // Digit DP: scan s left to right; when s[i]='1', place a 0 there and
            // freely distribute (c - onesPlaced) ones in the remaining (n-1-i) positions
            int onesPlaced = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    int remaining = n - 1 - i;
                    int need = c - onesPlaced;
                    if (need >= 0 && need <= remaining) {
                        ans = (ans + C[remaining][need]) % MOD;
                    }
                    onesPlaced++;
                }
                if (onesPlaced > c) {
                    break;
                }
            }
        }
        return (int) ans;
    }
}
