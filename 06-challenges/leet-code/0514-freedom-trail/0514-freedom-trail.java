// https://leetcode.com/problems/freedom-trail/

// Solution: DP — O(m*n^2) time, O(m*n) space
class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        // charPositions[c] = list of indices in ring where char c appears
        List<Integer>[] charPositions = new List[26];
        for (int i = 0; i < 26; i++) {
            charPositions[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            charPositions[ring.charAt(i) - 'a'].add(i);
        }
        // dp[i][j] = min steps to spell key[i..] when currently at ring position j
        int[][] dp = new int[m + 1][n];
        for (int i = m - 1; i >= 0; i--) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                for (int nextPos : charPositions[key.charAt(i) - 'a']) {
                    int diff = Math.abs(j - nextPos);
                    int rotCost = Math.min(diff, n - diff);
                    int total = rotCost + 1 + dp[i + 1][nextPos];
                    dp[i][j] = Math.min(dp[i][j], total);
                }
            }
        }
        return dp[0][0];
    }
}
