// https://leetcode.com/problems/find-maximum-removals-from-source-string/

class Solution {
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        int n = source.length(), m = pattern.length();
        Set<Integer> targets = new HashSet<>();
        for (int idx : targetIndices) {
            targets.add(idx);
        }
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int[] ndp = dp.clone();
            boolean isTarget = targets.contains(i);
            for (int j = 0; j <= m; j++) {
                if (dp[j] == Integer.MIN_VALUE) {
                    continue;
                }
                // Remove source[i] (only if it's a target index)
                if (isTarget) {
                    ndp[j] = Math.max(ndp[j], dp[j] + 1);
                }
                // Use source[i] to match pattern[j]
                if (j < m && source.charAt(i) == pattern.charAt(j)) {
                    ndp[j + 1] = Math.max(ndp[j + 1], dp[j]);
                }
            }
            dp = ndp;
        }
        return dp[m];
    }
}
