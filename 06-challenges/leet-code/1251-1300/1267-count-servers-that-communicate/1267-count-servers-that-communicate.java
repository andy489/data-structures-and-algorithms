// https://leetcode.com/problems/count-servers-that-communicate/

// Solution: Row/Column Count — O(m*n) time, O(m+n) space
// Solution: Row/Column Count — O(m*n) time, O(m+n) space
class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowCount = new int[m], colCount = new int[n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (grid[i][j] == 1) { rowCount[i]++; colCount[j]++; }
        int res = 0;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) res++;
        return res;
    }
}
