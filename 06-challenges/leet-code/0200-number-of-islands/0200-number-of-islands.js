// https://leetcode.com/problems/number-of-islands/

const DIRS = [-1, 0, 1, 0, -1];

// Solution: DFS with in-place marking — O(m·n) time, O(m·n) space
var numIslands = function(grid) {
    const m = grid.length;
    const n = grid[0].length;

    function dfs(r, c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] !== '1') {
            return;
        }

        grid[r][c] = '0';

        for (let k = 0; k < 4; k++) {
            dfs(r + DIRS[k], c + DIRS[k + 1]);
        }
    }

    let count = 0;

    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            if (grid[r][c] === '1') {
                count++;
                dfs(r, c);
            }
        }
    }

    return count;
};

// Solution 2: BFS with in-place marking — O(m·n) time, O(min(m,n)) space
var numIslands2 = function(grid) {
    const m = grid.length;
    const n = grid[0].length;
    let count = 0;

    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            if (grid[r][c] === '1') {
                count++;
                grid[r][c] = '0';
                const queue = [[r, c]];

                while (queue.length > 0) {
                    const [cr, cc] = queue.shift();

                    for (let k = 0; k < 4; k++) {
                        const nr = cr + DIRS[k];
                        const nc = cc + DIRS[k + 1];

                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] === '1') {
                            grid[nr][nc] = '0';
                            queue.push([nr, nc]);
                        }
                    }
                }
            }
        }
    }

    return count;
};
