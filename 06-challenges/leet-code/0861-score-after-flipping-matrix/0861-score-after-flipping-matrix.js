// https://leetcode.com/problems/score-after-flipping-matrix/

var matrixScore = function(grid) {
    const m = grid.length, n = grid[0].length;
    for (let r = 0; r < m; r++) {
        if (grid[r][0] === 0) {
            for (let c = 0; c < n; c++) grid[r][c] ^= 1;
        }
    }
    let score = 0;
    for (let c = 0; c < n; c++) {
        let ones = 0;
        for (let r = 0; r < m; r++) ones += grid[r][c];
        score += Math.max(ones, m - ones) * (1 << (n - 1 - c));
    }
    return score;
};
