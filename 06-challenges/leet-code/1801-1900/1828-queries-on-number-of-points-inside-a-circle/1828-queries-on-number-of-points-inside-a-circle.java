// https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/

// Solution: Brute Force — O(n*q) time, O(1) space
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cx = queries[i][0], cy = queries[i][1], r = queries[i][2];
            for (int[] p : points) {
                int dx = p[0] - cx, dy = p[1] - cy;
                if (dx * dx + dy * dy <= r * r) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
