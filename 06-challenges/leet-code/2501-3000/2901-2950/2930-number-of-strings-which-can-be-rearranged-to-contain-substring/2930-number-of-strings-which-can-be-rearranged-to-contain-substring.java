// https://leetcode.com/problems/number-of-strings-which-can-be-rearranged-to-contain-substring/

// Solution: Inclusion-Exclusion on Character Counts — O(log n) time, O(1) space
class Solution {
    private static final long MOD = 1_000_000_007L;

    private long pow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    public int stringCount(int n) {
        // A: no 'l', B: at most 1 'e', C: no 't'
        long a = pow(25, n, MOD);
        long b = (pow(25, n, MOD) + (long) n % MOD * pow(25, n - 1, MOD)) % MOD;
        long c = pow(25, n, MOD);
        long ab = (pow(24, n, MOD) + (long) n % MOD * pow(24, n - 1, MOD)) % MOD;
        long ac = pow(24, n, MOD);
        long bc = (pow(24, n, MOD) + (long) n % MOD * pow(24, n - 1, MOD)) % MOD;
        long abc = (pow(23, n, MOD) + (long) n % MOD * pow(23, n - 1, MOD)) % MOD;
        long bad = (a + b + c - ab - ac - bc + abc + 3 * MOD) % MOD;
        return (int) ((pow(26, n, MOD) - bad + MOD) % MOD);
    }
}
