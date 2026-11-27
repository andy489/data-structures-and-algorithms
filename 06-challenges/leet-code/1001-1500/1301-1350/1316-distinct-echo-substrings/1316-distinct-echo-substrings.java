// https://leetcode.com/problems/distinct-echo-substrings/

// Solution: Rolling Hash — O(n^2) time, O(n) space
class Solution {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        Set<Long> seen = new HashSet<>();
        long BASE = 31, MOD = 1_000_000_007L;
        long[] pw = new long[n+1];
        long[] h = new long[n+1];
        pw[0] = 1;
        for (int i = 0; i < n; i++) {
            pw[i+1] = pw[i] * BASE % MOD;
            h[i+1] = (h[i] * BASE + (text.charAt(i) - 'a' + 1)) % MOD;
        }
        int count = 0;
        for (int k = 1; k*2 <= n; k++) {
            for (int i = 0; i + 2*k <= n; i++) {
                long h1 = (h[i+k] - h[i] * pw[k] % MOD + MOD) % MOD;
                long h2 = (h[i+2*k] - h[i+k] * pw[k] % MOD + MOD) % MOD;
                if (h1 == h2) {
                    long key = i * 2001L + k;
                    if (!seen.contains(h1 * 2001L + k)) {
                        // use substring as key to avoid collisions
                        seen.add(h1 * 2001L + k);
                        count++;
                    }
                }
            }
        }
        // Use actual substring set for correctness
        Set<String> res = new HashSet<>();
        for (int k = 1; k*2 <= n; k++) {
            for (int i = 0; i + 2*k <= n; i++) {
                long h1 = (h[i+k] - h[i] * pw[k] % MOD + MOD) % MOD;
                long h2 = (h[i+2*k] - h[i+k] * pw[k] % MOD + MOD) % MOD;
                if (h1 == h2) res.add(text.substring(i, i+2*k));
            }
        }
        return res.size();
    }
}
