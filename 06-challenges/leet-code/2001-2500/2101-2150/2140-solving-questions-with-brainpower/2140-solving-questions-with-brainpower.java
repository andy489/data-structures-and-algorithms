// https://leetcode.com/problems/solving-questions-with-brainpower/
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            long points = questions[i][0];
            int skip = questions[i][1];
            int next = Math.min(n, i + skip + 1);
            dp[i] = Math.max(dp[i + 1], points + dp[next]);
        }
        return dp[0];
    }
}
