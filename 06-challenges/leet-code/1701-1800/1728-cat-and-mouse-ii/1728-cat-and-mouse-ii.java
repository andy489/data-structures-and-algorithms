// https://leetcode.com/problems/cat-and-mouse-ii/

// Solution: Minimax with Memoization — O(m^2·n^2·T) time, O(m^2·n^2·T) space
class Solution {
    private char[][] grid;
    private int rows, cols, cj, mj, fr, fc;
    private Boolean[][][][][] dp;
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean canMouseWin(String[] gridS, int catJump, int mouseJump) {
        rows = gridS.length;
        cols = gridS[0].length();
        cj = catJump;
        mj = mouseJump;
        grid = new char[rows][cols];
        int mr = 0, mc = 0, cr = 0, cc = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = gridS[i].charAt(j);
                if (grid[i][j] == 'M') { mr = i; mc = j; }
                if (grid[i][j] == 'C') { cr = i; cc = j; }
                if (grid[i][j] == 'F') { fr = i; fc = j; }
            }
        }
        dp = new Boolean[rows][cols][rows][cols][129];
        return solve(mr, mc, cr, cc, 0);
    }

    private boolean solve(int mr, int mc, int cr, int cc, int turn) {
        if (turn == 128) {
            return false;
        }
        if (mr == cr && mc == cc) {
            return false;
        }
        if (mr == fr && mc == fc) {
            return true;
        }
        if (dp[mr][mc][cr][cc][turn] != null) {
            return dp[mr][mc][cr][cc][turn];
        }
        boolean result;
        if (turn % 2 == 0) {
            // Mouse's turn — mouse wins if any move leads to win
            result = false;
            loop:
            for (int[] d : dirs) {
                for (int jump = 0; jump <= mj; jump++) {
                    int nr = mr + d[0] * jump, nc = mc + d[1] * jump;
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] == '#') {
                        break;
                    }
                    if (solve(nr, nc, cr, cc, turn + 1)) {
                        result = true;
                        break loop;
                    }
                }
            }
        } else {
            // Cat's turn — cat wins if any move leads to loss for mouse
            result = true;
            loop:
            for (int[] d : dirs) {
                for (int jump = 0; jump <= cj; jump++) {
                    int nr = cr + d[0] * jump, nc = cc + d[1] * jump;
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] == '#') {
                        break;
                    }
                    if (!solve(mr, mc, nr, nc, turn + 1)) {
                        result = false;
                        break loop;
                    }
                }
            }
        }
        dp[mr][mc][cr][cc][turn] = result;
        return result;
    }
}
