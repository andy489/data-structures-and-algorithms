// https://leetcode.com/problems/max-area-of-island/

var maxAreaOfIsland = function(grid) {
    const m = grid.length, n = grid[0].length;

    function dfs(r, c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] === 0) return 0;
        grid[r][c] = 0;
        return 1 + dfs(r+1,c) + dfs(r-1,c) + dfs(r,c+1) + dfs(r,c-1);
    }

    let maxArea = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) maxArea = Math.max(maxArea, dfs(i, j));
        }
    }
    return maxArea;
};
