// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

// Solution: DFS + Memoization — O(m*n) time, O(m*n) space
class Solution {
    private static final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j, memo));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] > 0) {
            return memo[r][c];
        }
        int best = 1;
        for (int[] d : DIRS) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length
                    && matrix[nr][nc] > matrix[r][c]) {
                best = Math.max(best, 1 + dfs(matrix, nr, nc, memo));
            }
        }
        return memo[r][c] = best;
    }
}
