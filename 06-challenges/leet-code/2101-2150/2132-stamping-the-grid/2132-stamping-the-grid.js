// https://leetcode.com/problems/stamping-the-grid/
var possibleToStamp = function(grid, stampHeight, stampWidth) {
    const m = grid.length, n = grid[0].length;
    // Build prefix sum of grid
    const ps = Array.from({length: m + 1}, () => new Array(n + 1).fill(0));
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            ps[i][j] = grid[i-1][j-1] + ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1];
        }
    }
    const query = (arr, r1, c1, r2, c2) =>
        arr[r2][c2] - arr[r1-1][c2] - arr[r2][c1-1] + arr[r1-1][c1-1];

    // Mark valid stamp placements
    const stamps = Array.from({length: m + 1}, () => new Array(n + 1).fill(0));
    for (let i = 1; i + stampHeight - 1 <= m; i++) {
        for (let j = 1; j + stampWidth - 1 <= n; j++) {
            if (query(ps, i, j, i + stampHeight - 1, j + stampWidth - 1) === 0) {
                stamps[i][j]++;
            }
        }
    }

    // Build prefix sum of stamp placements
    const sps = Array.from({length: m + 1}, () => new Array(n + 1).fill(0));
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            sps[i][j] = stamps[i][j] + sps[i-1][j] + sps[i][j-1] - sps[i-1][j-1];
        }
    }

    // Check every empty cell is covered
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (grid[i-1][j-1] === 0) {
                const r1 = Math.max(1, i - stampHeight + 1);
                const c1 = Math.max(1, j - stampWidth + 1);
                if (query(sps, r1, c1, i, j) === 0) {
                    return false;
                }
            }
        }
    }
    return true;
};
