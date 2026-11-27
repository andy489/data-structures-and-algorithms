// https://leetcode.com/problems/find-the-number-of-possible-ways-for-an-event/

class Solution {
    private static final long MOD = 1_000_000_007L;

    public long numberOfWays(int n, int x, int y) {
        // Precompute Stirling numbers S[i][j] for i in [0..n], j in [0..min(n,x)]
        int maxK = Math.min(n, x);
        long[][] S = new long[n + 1][maxK + 1];
        S[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxK; j++) {
                S[i][j] = (j * S[i - 1][j] % MOD + S[i - 1][j - 1]) % MOD;
            }
        }
        // Precompute C(x, k) * k! = x! / (x-k)! = falling factorial P(x, k)
        // Precompute P(y, k) = y * (y-1) * ... * (y-k+1)
        long result = 0;
        long pxk = 1; // P(x, k)
        long pyk = 1; // P(y, k)
        for (int k = 1; k <= maxK; k++) {
            pxk = pxk * ((x - k + 1) % MOD) % MOD;
            pyk = pyk * ((y - k + 1 > 0 ? y - k + 1 : 0) % MOD) % MOD;
            if (y - k + 1 <= 0) {
                break;
            }
            result = (result + S[n][k] % MOD * pxk % MOD * pyk) % MOD;
        }
        return result;
    }
}
