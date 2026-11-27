// https://leetcode.com/problems/palindrome-partitioning/

// Solution 1: Backtracking with inline palindrome check — O(n·2ⁿ) time, O(n) extra space
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalin(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalin(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}

// Solution 2: Backtracking + DP palindrome table — O(n²) pre-computation, O(n·2ⁿ) backtracking
class Solution2 {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int i = 0; i < n - 1; i++) dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res, dp);
        return res;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> res, boolean[][] dp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path, res, dp);
                path.remove(path.size() - 1);
            }
        }
    }
}
