// https://leetcode.com/problems/minimum-number-of-operations-to-make-string-sorted/

// Solution: Factorial Rank — O(n * 26) time, O(n) space
class Solution {
    private static final long MOD = 1_000_000_007L;

    private long power(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    public int makeStringSorted(String s) {
        int n = s.length();
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // invFact[i] = modular inverse of i!
        long[] invFact = new long[n + 1];
        invFact[n] = power(fact[n], MOD - 2, MOD);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'a';
            long smaller = 0;
            for (int j = 0; j < cur; j++) {
                smaller += cnt[j];
            }
            int remaining = n - 1 - i;
            long ways = fact[remaining];
            for (int j = 0; j < 26; j++) {
                int c2 = cnt[j] - (j == cur ? 1 : 0);
                ways = ways * invFact[c2] % MOD;
            }
            ans = (ans + smaller % MOD * ways) % MOD;
            cnt[cur]--;
        }
        return (int) ans;
    }
}
