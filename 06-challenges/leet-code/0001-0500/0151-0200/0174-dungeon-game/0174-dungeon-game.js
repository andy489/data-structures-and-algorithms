// https://leetcode.com/problems/dungeon-game/

// DP from bottom-right — O(m*n) time, O(n) space
var calculateMinimumHP = function(dungeon) {
    const m = dungeon.length, n = dungeon[0].length;
    let dp = new Array(n + 1).fill(Infinity);
    dp[n - 1] = 1;
    for (let i = m - 1; i >= 0; i--) {
        const nd = new Array(n + 1).fill(Infinity);
        nd[n - 1] = 1;
        for (let j = n - 1; j >= 0; j--) {
            const need = Math.min(dp[j], nd[j + 1]);
            nd[j] = Math.max(1, need - dungeon[i][j]);
        }
        dp = nd;
    }
    return dp[0];
};
