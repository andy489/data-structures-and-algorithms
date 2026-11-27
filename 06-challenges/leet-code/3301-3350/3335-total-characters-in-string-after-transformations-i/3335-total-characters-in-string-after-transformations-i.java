// https://leetcode.com/problems/total-characters-in-string-after-transformations-i/

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        long[] freq = new long[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int step = 0; step < t; step++) {
            long[] newFreq = new long[26];
            for (int i = 0; i < 25; i++) {
                newFreq[i + 1] = (newFreq[i + 1] + freq[i]) % MOD;
            }
            // 'z' -> "ab"
            newFreq[0] = (newFreq[0] + freq[25]) % MOD;
            newFreq[1] = (newFreq[1] + freq[25]) % MOD;
            freq = newFreq;
        }
        long ans = 0;
        for (long f : freq) {
            ans = (ans + f) % MOD;
        }
        return (int) ans;
    }
}
