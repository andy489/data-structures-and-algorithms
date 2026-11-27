// https://leetcode.com/problems/largest-local-values-in-a-matrix-ii/

class Solution {
    public int largestLocal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int x = matrix[r][c];
                if (x == 0) {
                    continue;
                }
                boolean isMax = true;
                outer:
                for (int dr = -x; dr <= x && isMax; dr++) {
                    for (int dc = -x; dc <= x && isMax; dc++) {
                        // skip corners where both distances equal x
                        if (Math.abs(dr) == x && Math.abs(dc) == x) {
                            continue;
                        }
                        int nr = r + dr;
                        int nc = c + dc;
                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                            continue;
                        }
                        if (matrix[nr][nc] > x) {
                            isMax = false;
                        }
                    }
                }
                if (isMax) {
                    count++;
                }
            }
        }
        return count;
    }
}
