// https://leetcode.com/problems/remove-boxes/
// Solution: 3D interval DP — O(n^4) time, O(n^3) space
class Solution {
    private int[] boxes;
    private int[][][] memo;

    public int removeBoxes(int[] boxes) {
        this.boxes = boxes;
        int n = boxes.length;
        memo = new int[n][n][n];
        return dp(0, n - 1, 0);
    }

    private int dp(int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (memo[l][r][k] != 0) {
            return memo[l][r][k];
        }
        int result = (k + 1) * (k + 1) + dp(l + 1, r, 0);
        for (int m = l + 1; m <= r; m++) {
            if (boxes[m] == boxes[l]) {
                result = Math.max(result, dp(l + 1, m - 1, 0) + dp(m, r, k + 1));
            }
        }
        memo[l][r][k] = result;
        return result;
    }
}
