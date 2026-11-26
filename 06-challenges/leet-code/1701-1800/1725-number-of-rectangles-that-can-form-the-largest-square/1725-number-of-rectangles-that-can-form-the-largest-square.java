// https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0, count = 0;
        for (int[] r : rectangles) {
            int side = Math.min(r[0], r[1]);
            if (side > maxLen) {
                maxLen = side;
                count = 1;
            } else if (side == maxLen) {
                count++;
            }
        }
        return count;
    }
}
