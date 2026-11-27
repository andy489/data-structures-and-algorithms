// https://leetcode.com/problems/maximum-trailing-zeros-in-a-cornered-path/

class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] r2 = new int[m][n + 1];
        int[][] r5 = new int[m][n + 1];
        int[][] c2 = new int[m + 1][n];
        int[][] c5 = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                int tw = 0, fi = 0;
                while (v % 2 == 0) { v /= 2; tw++; }
                v = grid[i][j];
                while (v % 5 == 0) { v /= 5; fi++; }
                r2[i][j + 1] = r2[i][j] + tw;
                r5[i][j + 1] = r5[i][j] + fi;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int v = grid[i][j];
                int tw = 0, fi = 0;
                while (v % 2 == 0) { v /= 2; tw++; }
                v = grid[i][j];
                while (v % 5 == 0) { v /= 5; fi++; }
                c2[i + 1][j] = c2[i][j] + tw;
                c5[i + 1][j] = c5[i][j] + fi;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int leftTwo = r2[i][j + 1];
                int leftFive = r5[i][j + 1];
                int rightTwo = r2[i][n] - r2[i][j];
                int rightFive = r5[i][n] - r5[i][j];
                int upTwo = c2[i + 1][j];
                int upFive = c5[i + 1][j];
                int downTwo = c2[m][j] - c2[i][j];
                int downFive = c5[m][j] - c5[i][j];

                ans = Math.max(ans, Math.min(leftTwo + upTwo, leftFive + upFive));
                ans = Math.max(ans, Math.min(leftTwo + downTwo, leftFive + downFive));
                ans = Math.max(ans, Math.min(rightTwo + upTwo, rightFive + upFive));
                ans = Math.max(ans, Math.min(rightTwo + downTwo, rightFive + downFive));
            }
        }
        return ans;
    }
}
