// https://leetcode.com/problems/path-with-maximum-gold/

var getMaximumGold = function(grid) {
    const m = grid.length, n = grid[0].length;
    function dfs(i, j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] === 0) return 0;
        const gold = grid[i][j]; grid[i][j] = 0;
        const best = gold + Math.max(dfs(i+1,j), dfs(i-1,j), dfs(i,j+1), dfs(i,j-1));
        grid[i][j] = gold; return best;
    }
    let res = 0;
    for (let i = 0; i < m; i++) for (let j = 0; j < n; j++) res = Math.max(res, dfs(i, j));
    return res;
};
