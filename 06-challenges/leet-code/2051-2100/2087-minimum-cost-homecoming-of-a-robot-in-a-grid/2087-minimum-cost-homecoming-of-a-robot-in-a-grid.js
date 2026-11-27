// https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/

// Solution: Greedy — O(m+n) time, O(1) space
var minCost = function(startPos, homePos, rowCosts, colCosts) {
    let cost = 0;
    const [r, c] = startPos, [hr, hc] = homePos;
    const dr = hr > r ? 1 : -1, dc = hc > c ? 1 : -1;
    for (let row = r + dr; row !== hr + dr; row += dr) cost += rowCosts[row];
    for (let col = c + dc; col !== hc + dc; col += dc) cost += colCosts[col];
    return cost;
};
