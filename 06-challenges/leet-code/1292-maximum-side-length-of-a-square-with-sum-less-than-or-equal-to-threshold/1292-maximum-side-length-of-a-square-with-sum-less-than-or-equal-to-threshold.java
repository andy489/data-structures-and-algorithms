// https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/

// Solution: 2D Prefix Sums — O(m*n*min(m,n)) time, O(m*n) space
// Solution: 2D Prefix Sums — O(m*n*min(m,n)) time, O(m*n) space
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) for (int j = 1; j <= n; j++)
            pre[i][j] = mat[i-1][j-1] + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
        int res = 0;
        for (int k = 1; k <= Math.min(m, n); k++) {
            boolean found = false;
            for (int i = k; i <= m && !found; i++) for (int j = k; j <= n && !found; j++) {
                int sum = pre[i][j] - pre[i-k][j] - pre[i][j-k] + pre[i-k][j-k];
                if (sum <= threshold) { res = k; found = true; }
            }
            if (!found) break;
        }
        return res;
    }
}
