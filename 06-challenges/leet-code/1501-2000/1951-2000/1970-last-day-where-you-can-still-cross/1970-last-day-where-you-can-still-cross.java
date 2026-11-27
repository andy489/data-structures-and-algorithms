// https://leetcode.com/problems/last-day-where-you-can-still-cross/
class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int lo = 1, hi = cells.length;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (canCross(row, col, cells, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        boolean[][] water = new boolean[row][col];
        for (int i = 0; i < day; i++) {
            water[cells[i][0] - 1][cells[i][1] - 1] = true;
        }
        int[][] queue = new int[row * col][2];
        int head = 0, tail = 0;
        for (int c = 0; c < col; c++) {
            if (!water[0][c]) {
                queue[tail++] = new int[]{0, c};
                water[0][c] = true;
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (head < tail) {
            int[] cur = queue[head++];
            if (cur[0] == row - 1) {
                return true;
            }
            for (int[] d : dirs) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !water[nr][nc]) {
                    water[nr][nc] = true;
                    queue[tail++] = new int[]{nr, nc};
                }
            }
        }
        return false;
    }
}
