// https://leetcode.com/problems/grid-game/

// Solution: Prefix Sums — O(n) time, O(1) space
var gridGame = function(grid) {
    const n = grid[0].length;
    let top = grid[0].reduce((a, b) => a + b, 0), bot = 0, res = Infinity;
    for (let i = 0; i < n; i++) {
        top -= grid[0][i];
        res = Math.min(res, Math.max(top, bot));
        bot += grid[1][i];
    }
    return res;
};
