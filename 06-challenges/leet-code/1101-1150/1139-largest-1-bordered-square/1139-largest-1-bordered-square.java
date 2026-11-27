// https://leetcode.com/problems/largest-1-bordered-square/

// Solution: Prefix Sums (Horizontal + Vertical) — O(m*n*min(m,n)) time, O(m*n) space
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] hor = new int[m][n];
        int[][] ver = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hor[i][j] = (j > 0 ? hor[i][j - 1] : 0) + 1;
                    ver[i][j] = (i > 0 ? ver[i - 1][j] : 0) + 1;
                }
            }
        }

        for (int s = Math.min(m, n); s >= 1; s--) {
            for (int i = s - 1; i < m; i++) {
                for (int j = s - 1; j < n; j++) {
                    if (hor[i][j] >= s && ver[i][j] >= s
                            && hor[i - s + 1][j] >= s
                            && ver[i][j - s + 1] >= s) {
                        return s * s;
                    }
                }
            }
        }
        return 0;
    }
}
