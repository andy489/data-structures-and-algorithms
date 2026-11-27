// https://leetcode.com/problems/word-break/

// Solution 1: Bottom-Up DP — O(n²·m) time, O(n) space
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String w : words) {
                int len = w.length();
                if (i >= len && dp[i - len] && s.substring(i - len, i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}

// Solution 2: Top-Down Memoized DFS — O(n²) time, O(n) space
class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, 0, words, memo);
    }

    private boolean dfs(String s, int start, Set<String> words, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        for (int end = start + 1; end <= s.length(); end++) {
            if (words.contains(s.substring(start, end)) && dfs(s, end, words, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
