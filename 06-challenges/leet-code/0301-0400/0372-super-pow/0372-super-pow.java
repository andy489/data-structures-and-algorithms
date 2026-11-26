// https://leetcode.com/problems/super-pow/

// Solution: Modular Exponentiation — O(n) time, O(1) space
class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int result = 1;
        a %= MOD;
        for (int d : b) {
            result = powMod(result, 10) * powMod(a, d) % MOD;
        }
        return result;
    }

    private int powMod(int base, int exp) {
        base %= MOD;
        int res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = res * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }
}
