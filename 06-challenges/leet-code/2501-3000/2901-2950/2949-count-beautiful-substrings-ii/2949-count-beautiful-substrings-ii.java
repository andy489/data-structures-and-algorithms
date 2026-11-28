// https://leetcode.com/problems/count-beautiful-substrings-ii/

// Solution: Prefix Sum + HashMap by (prefix_diff, prefix_mod) — O(n*sqrt(k)) time, O(n*sqrt(k)) space
class Solution {
    public long beautifulSubstrings(String s, int k) {
        // Find smallest p such that p*p % k == 0
        int p = 1;
        while ((p * p) % k != 0) {
            p++;
        }
        int period = 2 * p;

        int n = s.length();
        long count = 0;
        // prefix: +1 for vowel, -1 for consonant, so pre[i] = sum s[0..i-1]
        // We store cumulative value and use it as offset by n to avoid negative keys
        // Key: (pre[j] + n, j % period)
        Map<Long, Integer> freq = new HashMap<>();
        int pre = 0;
        freq.put(encode(0, 0, period, n), 1);
        String vowels = "aeiou";
        for (int j = 0; j < n; j++) {
            pre += vowels.indexOf(s.charAt(j)) >= 0 ? 1 : -1;
            long key = encode(pre, (j + 1) % period, period, n);
            count += freq.getOrDefault(key, 0);
            freq.merge(key, 1, Integer::sum);
        }
        return count;
    }

    private long encode(int pre, int mod, int period, int n) {
        return (long) (pre + n) * period + mod;
    }
}
