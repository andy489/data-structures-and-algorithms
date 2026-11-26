// https://leetcode.com/problems/check-if-it-is-a-straight-line/

// Solution: Cross Product — O(n) time, O(1) space
// Solution: Cross Product — O(n) time, O(1) space
class Solution {
    public boolean checkStraightLine(int[][] c) {
        int dx = c[1][0] - c[0][0], dy = c[1][1] - c[0][1];
        for (int i = 2; i < c.length; i++) {
            if ((c[i][0] - c[0][0]) * dy != (c[i][1] - c[0][1]) * dx) return false;
        }
        return true;
    }
}
