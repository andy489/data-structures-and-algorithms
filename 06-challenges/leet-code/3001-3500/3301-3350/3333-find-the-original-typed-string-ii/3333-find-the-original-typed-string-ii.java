// https://leetcode.com/problems/find-the-original-typed-string-ii/

class Solution {
    public int possibleStringCount(String word, int k) {
        final int MOD = 1_000_000_007;
        // Build runs
        List<Integer> runs = new ArrayList<>();
        int i = 0;
        while (i < word.length()) {
            int j = i;
            while (j < word.length() && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            runs.add(j - i);
            i = j;
        }
        int m = runs.size();
        // Total = product of all run lengths
        long total = 1;
        for (int r : runs) {
            total = total * r % MOD;
        }
        if (k <= m) {
            return (int) total;
        }
        // Count strings with length < k (i.e., length in [m, k-1])
        // dp[j] = number of ways to get exactly length j for first 'idx' runs
        // We need lengths from m (minimum, one char per run) to k-1
        int maxLen = k - 1;
        long[] dp = new long[maxLen + 1];
        dp[0] = 1;
        // prefix sum for sliding window
        for (int idx = 0; idx < m; idx++) {
            int runLen = runs.get(idx);
            long[] newDp = new long[maxLen + 1];
            long[] prefix = new long[maxLen + 2];
            for (int j = 0; j <= maxLen; j++) {
                prefix[j + 1] = (prefix[j] + dp[j]) % MOD;
            }
            // For each new length j', we can pick 1..runLen chars from run idx
            // newDp[j'] = sum of dp[j'-1], dp[j'-2], ..., dp[j'-runLen] for valid indices
            for (int j = 1; j <= maxLen; j++) {
                int lo = Math.max(0, j - runLen);
                int hi = j - 1;
                newDp[j] = (prefix[hi + 1] - prefix[lo] + MOD) % MOD;
            }
            dp = newDp;
        }
        // Sum dp[m..k-1]
        long bad = 0;
        for (int j = m; j <= maxLen; j++) {
            bad = (bad + dp[j]) % MOD;
        }
        return (int) ((total - bad + MOD) % MOD);
    }
}
