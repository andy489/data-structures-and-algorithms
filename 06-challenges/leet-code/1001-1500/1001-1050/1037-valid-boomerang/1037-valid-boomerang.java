// https://leetcode.com/problems/valid-boomerang/

// Solution: Cross Product — O(1) time, O(1) space
class Solution {
    public boolean isBoomerang(int[][] points) {
        int dx1 = points[1][0] - points[0][0], dy1 = points[1][1] - points[0][1];
        int dx2 = points[2][0] - points[0][0], dy2 = points[2][1] - points[0][1];
        return dx1 * dy2 - dy1 * dx2 != 0;
    }
}
