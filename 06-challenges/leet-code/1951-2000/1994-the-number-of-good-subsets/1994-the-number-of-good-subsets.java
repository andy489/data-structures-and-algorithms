// https://leetcode.com/problems/the-number-of-good-subsets/
class Solution {
    static final int MOD = 1_000_000_007;
    static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public int numberOfGoodSubsets(int[] nums) {
        int[] count = new int[31];
        for (int x : nums) {
            count[x]++;
        }
        int[] primeMask = new int[31];
        for (int v = 2; v <= 30; v++) {
            int temp = v;
            boolean valid = true;
            for (int i = 0; i < PRIMES.length; i++) {
                int p = PRIMES[i];
                if (temp % p == 0) {
                    primeMask[v] |= (1 << i);
                    temp /= p;
                    if (temp % p == 0) {
                        valid = false;
                        break;
                    }
                }
            }
            if (!valid) {
                primeMask[v] = -1;
            }
        }
        long[] dp = new long[1 << PRIMES.length];
        dp[0] = 1;
        for (int v = 2; v <= 30; v++) {
            if (count[v] == 0 || primeMask[v] < 0) {
                continue;
            }
            int mask = primeMask[v];
            for (int prev = dp.length - 1; prev >= 0; prev--) {
                if (dp[prev] == 0 || (prev & mask) != 0) {
                    continue;
                }
                dp[prev | mask] = (dp[prev | mask] + dp[prev] * count[v]) % MOD;
            }
        }
        long result = 0;
        for (int mask = 1; mask < dp.length; mask++) {
            result = (result + dp[mask]) % MOD;
        }
        long pow2 = 1;
        for (int i = 0; i < count[1]; i++) {
            pow2 = pow2 * 2 % MOD;
        }
        result = result * pow2 % MOD;
        return (int) result;
    }
}
