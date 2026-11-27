// https://leetcode.com/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/

// Solution: Two DFS Passes — O(m*n) time, O(m*n) space
var isPossibleToCutPath = function(grid) {
    const m = grid.length, n = grid[0].length;

    function dfs(r, c) {
        if (r === m - 1 && c === n - 1) {
            return true;
        }
        if (r >= m || c >= n || grid[r][c] === 0) {
            return false;
        }
        grid[r][c] = 0;
        return dfs(r + 1, c) || dfs(r, c + 1);
    }

    if (!dfs(0, 0)) {
        return true;
    }
    grid[0][0] = 1;
    grid[m - 1][n - 1] = 1;
    return !dfs(0, 0);
};
