// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

// Solution: DFS + Memoization — O(m*n) time, O(m*n) space
var longestIncreasingPath = function(matrix) {
    const m = matrix.length, n = matrix[0].length;
    const memo = Array.from({length: m}, () => new Array(n).fill(0));
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];

    function dfs(r, c) {
        if (memo[r][c]) return memo[r][c];
        let best = 1;
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[r][c]) {
                best = Math.max(best, 1 + dfs(nr, nc));
            }
        }
        return memo[r][c] = best;
    }

    let result = 0;
    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            result = Math.max(result, dfs(r, c));
        }
    }
    return result;
};
