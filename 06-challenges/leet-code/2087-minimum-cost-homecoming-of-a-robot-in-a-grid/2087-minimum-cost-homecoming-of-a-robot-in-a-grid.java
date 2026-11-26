// https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/

// Solution: Greedy — O(m+n) time, O(1) space
class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int cost = 0;
        int r = startPos[0], c = startPos[1], hr = homePos[0], hc = homePos[1];
        int dr = hr > r ? 1 : -1, dc = hc > c ? 1 : -1;
        for (int row = r + dr; row != hr + dr; row += dr) { cost += rowCosts[row]; }
        for (int col = c + dc; col != hc + dc; col += dc) { cost += colCosts[col]; }
        return cost;
    }
}
