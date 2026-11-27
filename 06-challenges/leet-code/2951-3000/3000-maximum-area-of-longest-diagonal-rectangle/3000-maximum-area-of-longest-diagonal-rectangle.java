// https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/

// Solution: Greedy — O(n) time, O(1) space
class Solution {
    public int maximumAreaOfLongestDiagonalRectangle(int[][] dimensions) {
        int maxDiag2 = 0, maxArea = 0;
        for (int[] d : dimensions) {
            int diag2 = d[0] * d[0] + d[1] * d[1];
            int area = d[0] * d[1];
            if (diag2 > maxDiag2 || (diag2 == maxDiag2 && area > maxArea)) {
                maxDiag2 = diag2;
                maxArea = area;
            }
        }
        return maxArea;
    }
}
