// https://leetcode.com/problems/count-the-number-of-square-free-subsets/

class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public int squareFreeSubsets(int[] nums) {
        long[] dp = new long[1 << 10];
        dp[0] = 1;
        long ones = 0;

        for (int x : nums) {
            if (x == 1) {
                ones++;
                continue;
            }
            int mask = getPrimeMask(x);
            if (mask == -1) {
                continue; // has squared factor
            }
            for (int m = (1 << 10) - 1; m >= 0; m--) {
                if ((m & mask) == 0 && dp[m] > 0) {
                    dp[m | mask] = (dp[m | mask] + dp[m]) % MOD;
                }
            }
        }

        long result = 0;
        for (int m = 1; m < (1 << 10); m++) {
            result = (result + dp[m]) % MOD;
        }

        // Multiply by 2^ones (each 1 can be included or not in any existing subset)
        long pow2 = 1;
        for (long i = 0; i < ones; i++) {
            pow2 = pow2 * 2 % MOD;
        }
        result = result * pow2 % MOD;
        // Add subsets consisting only of 1s: 2^ones - 1
        result = (result + pow2 - 1 + MOD) % MOD;

        return (int) result;
    }

    private int getPrimeMask(int x) {
        int mask = 0;
        for (int i = 0; i < PRIMES.length; i++) {
            int p = PRIMES[i];
            if (x % p == 0) {
                x /= p;
                if (x % p == 0) {
                    return -1; // squared factor
                }
                mask |= (1 << i);
            }
        }
        return mask;
    }
}
