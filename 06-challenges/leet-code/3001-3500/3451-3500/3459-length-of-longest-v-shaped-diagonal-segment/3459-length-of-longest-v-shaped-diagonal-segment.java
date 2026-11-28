// https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/

// Solution: Dynamic Programming on Diagonals — O(n*m) time, O(n*m) space
class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // 4 diagonal directions: (1,1), (1,-1), (-1,1), (-1,-1)
        int[][] dirs = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        // Clockwise 90-degree turn mapping: (1,1)->(1,-1), (1,-1)->(-1,-1), (-1,-1)->(-1,1), (-1,1)->(1,1)
        int[] clockwise = {1, 3, 0, 2}; // dir 0->(dir 1), dir 1->(dir 3), dir 2->(dir 0), dir 3->(dir 2)
        // dp[r][c][d][t] = max length ending at (r,c) going direction d, t=0 no turn yet, t=1 turned
        int[][][][] dp = new int[n][m][4][2];
        int ans = 0;
        // Process in topological order based on direction
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    // Start of a new segment
                    for (int d = 0; d < 4; d++) {
                        dp[r][c][d][0] = 1;
                        dp[r][c][d][1] = 1;
                        ans = Math.max(ans, 1);
                    }
                }
            }
        }
        // We need to process cells such that (r-dr, c-dc) is processed before (r,c)
        // For each direction, do a forward pass
        // Direction 0: (1,1) -> process row 0 to n-1, col 0 to m-1
        // Direction 1: (1,-1) -> process row 0 to n-1, col m-1 to 0
        // Direction 2: (-1,1) -> process row n-1 to 0, col 0 to m-1
        // Direction 3: (-1,-1) -> process row n-1 to 0, col m-1 to 0
        int[][][] seq = {
            {new int[]{0, 1}, new int[]{0, n}, new int[]{0, m}},
            {new int[]{0, -1}, new int[]{0, n}, new int[]{m-1, -1}},
            {new int[]{-1, 1}, new int[]{n-1, -1}, new int[]{0, m}},
            {new int[]{-1, -1}, new int[]{n-1, -1}, new int[]{m-1, -1}}
        };
        // Expected values after leading 1: position p (1-indexed after start) -> (p%2==1)?2:0
        // At current cell, if prev had length L, expected grid val = (L%2==1)?2:0
        // Let's re-do with cleaner loop
        for (int pass = 0; pass < 2; pass++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    for (int d = 0; d < 4; d++) {
                        int pr = r - dirs[d][0], pc = c - dirs[d][1];
                        if (pr < 0 || pr >= n || pc < 0 || pc >= m) {
                            continue;
                        }
                        int expected = (dp[pr][pc][d][0] % 2 == 1) ? 2 : 0;
                        if (grid[r][c] == expected) {
                            if (dp[pr][pc][d][0] > 0) {
                                dp[r][c][d][0] = Math.max(dp[r][c][d][0], dp[pr][pc][d][0] + 1);
                                ans = Math.max(ans, dp[r][c][d][0]);
                            }
                        }
                        // Check if we can extend after a turn
                        int td = clockwise[d];
                        int expected2 = (dp[pr][pc][td][1] % 2 == 1) ? 2 : 0;
                        if (grid[r][c] == expected2 && dp[pr][pc][td][1] > 0) {
                            dp[r][c][d][1] = Math.max(dp[r][c][d][1], dp[pr][pc][td][1] + 1);
                            ans = Math.max(ans, dp[r][c][d][1]);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
