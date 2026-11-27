// https://leetcode.com/problems/knight-probability-in-chessboard/

// Solution: DP — O(k·n²) time, O(n²) space
class Solution {
    private static final int[][] MOVES = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        dp[row][column] = 1.0;
        for (int step = 0; step < k; step++) {
            double[][] next = new double[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] == 0) {
                        continue;
                    }
                    for (int[] move : MOVES) {
                        int nr = r + move[0], nc = c + move[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                            next[nr][nc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = next;
        }
        double prob = 0;
        for (double[] row2 : dp) {
            for (double v : row2) {
                prob += v;
            }
        }
        return prob;
    }
}
