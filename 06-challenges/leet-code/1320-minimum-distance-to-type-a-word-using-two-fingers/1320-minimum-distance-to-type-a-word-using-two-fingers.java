// https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/

// Solution: DP — O(n * 27^2) time, O(27^2) space
class Solution {
    private int dist(int a, int b) {
        if (a == 26) return 0;
        return Math.abs(a/6 - b/6) + Math.abs(a%6 - b%6);
    }
    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[27][27];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 2);
        dp[26][26] = 0;
        for (int i = 0; i < n; i++) {
            int c = word.charAt(i) - 'A';
            int[][] next = new int[27][27];
            for (int[] row : next) Arrays.fill(row, Integer.MAX_VALUE / 2);
            for (int f1 = 0; f1 <= 26; f1++) {
                for (int f2 = 0; f2 <= 26; f2++) {
                    if (dp[f1][f2] == Integer.MAX_VALUE / 2) continue;
                    // move f1 to c
                    next[c][f2] = Math.min(next[c][f2], dp[f1][f2] + dist(f1, c));
                    // move f2 to c
                    next[f1][c] = Math.min(next[f1][c], dp[f1][f2] + dist(f2, c));
                }
            }
            dp = next;
        }
        int ans = Integer.MAX_VALUE;
        for (int[] row : dp) for (int v : row) ans = Math.min(ans, v);
        return ans;
    }
}
