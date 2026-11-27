// https://leetcode.com/problems/maximum-path-intersection-sum-in-a-grid/
class Solution {
    public int maxPathIntersectionSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[r1][r2] = max sum of shared cells when player1 is at row r1
        // and player2 is at row r2 at the same step s
        // Player1: (r1, s-r1), Player2: (r2, s-r2) at step s
        // constraints: 0<=r1<=min(s,m-1), s-r1<=n-1 => r1>=s-n+1
        //              0<=m-1-r2<=s => r2>=m-1-s, r2<=m-1
        //              s-r2<=n-1 => r2>=s-n+1
        int steps = m + n - 2;
        int[][] dp = new int[m][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        // initial: s=0, player1 at (0,0), player2 at (m-1,0)
        dp[0][m - 1] = (0 == m - 1) ? grid[0][0] : 0;
        for (int s = 1; s <= steps; s++) {
            int[][] ndp = new int[m][m];
            for (int[] row : ndp) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
            int r1Min = Math.max(0, s - (n - 1));
            int r1Max = Math.min(s, m - 1);
            int r2Min = Math.max(0, (m - 1) - s);
            int r2Max = Math.min(m - 1, s + (m - 1) - (s > m - 1 ? s - (m - 1) : 0));
            // player2 row: at step s, player2 column = s - r2' where r2' increases up direction
            // player2 moves right or up: row decreases or col increases
            // player2 at step s: col2 = s - (m-1-r2) => r2' = m-1 - (steps moved up)
            // Let's reindex: p2row ranges, p2 at step s: col2 = s - (m-1 - p2row)
            // col2 = s - m + 1 + p2row, must be in [0, n-1]
            // p2row in [m-1-s, m-1] intersect [0, m-1]
            int p2rMin = Math.max(0, m - 1 - s);
            int p2rMax = m - 1;
            // further: col2 = s - m + 1 + p2row <= n-1 => p2row <= n - 2 - s + m
            p2rMax = Math.min(p2rMax, n - 2 - s + m);
            for (int r1 = r1Min; r1 <= r1Max; r1++) {
                int c1 = s - r1;
                if (c1 < 0 || c1 >= n) {
                    continue;
                }
                for (int r2 = p2rMin; r2 <= p2rMax; r2++) {
                    int c2 = s - m + 1 + r2;
                    if (c2 < 0 || c2 >= n) {
                        continue;
                    }
                    // transitions: r1 came from r1 (moved right) or r1-1 (moved down)
                    // r2 came from r2 (moved right) or r2+1 (moved up: row decreased)
                    // wait: p2 moves right or up, moving up decreases row index
                    // p2 col at step s-1 for p2row r2: c2_prev = c2-1 (moved right),
                    // or p2row_prev = r2+1 at col c2 (moved up from r2+1 to r2 at same col => same step transition)
                    // Actually: at step s-1, p2 was at (r2, c2-1) [moved right] or (r2+1, c2) [moved up: row was r2+1, now r2]
                    // but moving up: row becomes r2 from r2+1, col stays c2 => previous step col = c2 (unchanged)? No.
                    // Player2 moves: right (col+1) or up (row-1), both increment step by 1
                    // So from step s-1 to s:
                    //   right: (r2, c2-1) -> (r2, c2)
                    //   up: (r2+1, c2) -> (r2, c2)? col stays same but that's not right
                    // actually from (r2, c2) at step s:
                    //   came from (r2, c2-1) [moved right] or (r2+1, c2) [moved up: was at row r2+1, moved up to r2]
                    // at previous step s-1: p2 at (r2, c2-1): p2row_prev=r2, c2_prev=c2-1
                    //   p2_prev_col = s-1-m+1+r2 = c2-1 ✓
                    // or p2 at (r2+1, c2): p2row_prev=r2+1
                    //   c2_prev = s-1-m+1+(r2+1) = c2 ✓
                    int best = Integer.MIN_VALUE;
                    for (int pr1 = r1; pr1 >= r1 - 1; pr1--) {
                        if (pr1 < 0) {
                            continue;
                        }
                        for (int pr2 = r2; pr2 <= r2 + 1; pr2++) {
                            if (pr2 >= m) {
                                continue;
                            }
                            if (dp[pr1][pr2] != Integer.MIN_VALUE) {
                                best = Math.max(best, dp[pr1][pr2]);
                            }
                        }
                    }
                    if (best != Integer.MIN_VALUE) {
                        int add = (r1 == r2 && c1 == c2) ? grid[r1][c1] : 0;
                        ndp[r1][r2] = Math.max(ndp[r1][r2], best + add);
                    }
                }
            }
            dp = ndp;
        }
        // at step=steps: p1 at (m-1, n-1), p2 at (0, n-1)
        // r1=m-1, r2=0 (p2row=0 means p2 at row 0)
        return dp[m - 1][0];
    }
}
