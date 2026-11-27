// https://leetcode.com/problems/largest-1-bordered-square/

var largest1BorderedSquare = function(grid) {
    const m = grid.length, n = grid[0].length;
    const hor = Array.from({length: m}, () => new Array(n).fill(0));
    const ver = Array.from({length: m}, () => new Array(n).fill(0));

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j]) {
                hor[i][j] = (j > 0 ? hor[i][j - 1] : 0) + 1;
                ver[i][j] = (i > 0 ? ver[i - 1][j] : 0) + 1;
            }
        }
    }

    for (let s = Math.min(m, n); s >= 1; s--) {
        for (let i = s - 1; i < m; i++) {
            for (let j = s - 1; j < n; j++) {
                if (hor[i][j] >= s && ver[i][j] >= s
                        && hor[i - s + 1][j] >= s
                        && ver[i][j - s + 1] >= s) {
                    return s * s;
                }
            }
        }
    }
    return 0;
};
