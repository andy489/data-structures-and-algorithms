// https://leetcode.com/problems/count-number-of-balanced-permutations/

// Solution: DP + Combinatorics — O(10 * n * target) time, O(n * target) space
class Solution {
    static final int MOD = 1_000_000_007;

    public int countBalancedPermutations(String num) {
        int n = num.length();
        int[] cnt = new int[10];
        int total = 0;
        for (char ch : num.toCharArray()) {
            cnt[ch - '0']++;
            total += ch - '0';
        }
        if (total % 2 != 0) return 0;
        int target = total / 2;
        int evenSlots = (n + 1) / 2;
        int oddSlots = n / 2;

        long[] fact = new long[n + 1];
        long[] inv = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i % MOD;
        inv[n] = modPow(fact[n], MOD - 2, MOD);
        for (int i = n - 1; i >= 0; i--) inv[i] = inv[i + 1] * (i + 1) % MOD;

        // dp[placed][sumSoFar] = number of ways
        long[][] dp = new long[evenSlots + 1][target + 1];
        dp[0][0] = 1;

        for (int d = 0; d <= 9; d++) {
            int c = cnt[d];
            if (c == 0) continue;
            long[][] ndp = new long[evenSlots + 1][target + 1];
            for (int placed = 0; placed <= evenSlots; placed++) {
                for (int s = 0; s <= target; s++) {
                    if (dp[placed][s] == 0) continue;
                    for (int k = 0; k <= c && placed + k <= evenSlots && s + k * d <= target; k++) {
                        long ways = dp[placed][s] * comb(c, k, fact, inv) % MOD;
                        ndp[placed + k][s + k * d] = (ndp[placed + k][s + k * d] + ways) % MOD;
                    }
                }
            }
            dp = ndp;
        }

        long ans = dp[evenSlots][target];
        // multiply by evenSlots! * oddSlots! and divide by product of cnt[d]!
        ans = ans * fact[evenSlots] % MOD * fact[oddSlots] % MOD;
        for (int d = 0; d <= 9; d++) {
            ans = ans * inv[cnt[d]] % MOD;
        }
        return (int) ans;
    }

    private long comb(int n, int k, long[] fact, long[] inv) {
        if (k < 0 || k > n) return 0;
        return fact[n] * inv[k] % MOD * inv[n - k] % MOD;
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}
