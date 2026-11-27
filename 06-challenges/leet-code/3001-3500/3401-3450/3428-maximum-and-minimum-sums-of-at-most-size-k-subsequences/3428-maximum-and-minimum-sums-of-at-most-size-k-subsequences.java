// https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/

class Solution {
    private static final long MOD = 1_000_000_007L;

    public long minMaxSums(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        // Precompute factorials for combinations
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            // nums[i] as minimum: choose remaining from right side (n-1-i elements), up to k-1
            long minCoeff = sumComb(n - 1 - i, k - 1, fact, invFact);
            // nums[i] as maximum: choose remaining from left side (i elements), up to k-1
            long maxCoeff = sumComb(i, k - 1, fact, invFact);
            ans = (ans + (long) nums[i] % MOD * ((minCoeff + maxCoeff) % MOD)) % MOD;
        }
        return ans;
    }

    // sum_{j=0}^{r} C(n, j)
    private long sumComb(int n, int r, long[] fact, long[] invFact) {
        long sum = 0;
        for (int j = 0; j <= Math.min(r, n); j++) {
            sum = (sum + comb(n, j, fact, invFact)) % MOD;
        }
        return sum;
    }

    private long comb(int n, int r, long[] fact, long[] invFact) {
        if (r < 0 || r > n) {
            return 0;
        }
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
