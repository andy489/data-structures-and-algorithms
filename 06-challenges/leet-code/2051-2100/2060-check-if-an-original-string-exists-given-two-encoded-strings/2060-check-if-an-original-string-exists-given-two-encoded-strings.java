// https://leetcode.com/problems/check-if-an-original-string-exists-given-two-encoded-strings/

// Solution: DP with Offset Tracking — O(m*n*K) time, O(m*n*K) space
class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // dp[i][j] = set of possible 'diffs' (s1 ahead by diff chars) with i chars used in s1, j in s2
        Set<Integer>[][] dp = new HashSet[m + 1][n + 1];
        dp[0][0] = new HashSet<>();
        dp[0][0].add(0);
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (dp[i][j] == null) { continue; }
                for (int diff : dp[i][j]) {
                    // extend s1 from position i
                    if (i < m) {
                        if (Character.isLetter(s1.charAt(i))) {
                            if (dp[i + 1][j] == null) { dp[i + 1][j] = new HashSet<>(); }
                            if (diff > 0) { dp[i + 1][j].add(diff - 1); }
                            else if (diff == 0 && j < n && Character.isLetter(s2.charAt(j)) && s1.charAt(i) == s2.charAt(j)) {
                                // matched
                            }
                        }
                    }
                }
            }
        }
        // Simplified: use recursive DFS with memoization
        return dfs(s1, s2, 0, 0, 0, new HashMap<>());
    }
    private boolean dfs(String s1, String s2, int i, int j, int diff, Map<String, Boolean> memo) {
        String key = i + "," + j + "," + diff;
        if (memo.containsKey(key)) { return memo.get(key); }
        if (i == s1.length() && j == s2.length()) { return diff == 0; }
        boolean res = false;
        if (i < s1.length() && Character.isDigit(s1.charAt(i))) {
            int ni = i, num = 0;
            while (ni < s1.length() && Character.isDigit(s1.charAt(ni))) { num = num * 10 + (s1.charAt(ni++) - '0'); }
            res = dfs(s1, s2, ni, j, diff + num, memo);
        } else if (j < s2.length() && Character.isDigit(s2.charAt(j))) {
            int nj = j, num = 0;
            while (nj < s2.length() && Character.isDigit(s2.charAt(nj))) { num = num * 10 + (s2.charAt(nj++) - '0'); }
            res = dfs(s1, s2, i, nj, diff - num, memo);
        } else if (diff > 0 && i < s1.length()) {
            res = dfs(s1, s2, i + 1, j, diff - 1, memo);
        } else if (diff < 0 && j < s2.length()) {
            res = dfs(s1, s2, i, j + 1, diff + 1, memo);
        } else if (diff == 0 && i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) { res = dfs(s1, s2, i + 1, j + 1, 0, memo); }
        }
        memo.put(key, res);
        return res;
    }
}
