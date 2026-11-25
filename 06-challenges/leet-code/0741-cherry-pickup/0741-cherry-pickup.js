// https://leetcode.com/problems/cherry-pickup/

var cherryPickup = function(grid) {
    const n = grid.length;
    const NEG = -Infinity;
    let dp = Array.from({length: n}, () => new Array(n).fill(NEG));
    dp[0][0] = grid[0][0];
    for (let t = 1; t < 2 * n - 1; t++) {
        const ndp = Array.from({length: n}, () => new Array(n).fill(NEG));
        for (let r1 = Math.max(0, t - n + 1); r1 <= Math.min(t, n - 1); r1++) {
            const c1 = t - r1;
            if (grid[r1][c1] === -1) continue;
            for (let r2 = r1; r2 <= Math.min(t, n - 1); r2++) {
                const c2 = t - r2;
                if (grid[r2][c2] === -1) continue;
                const cherries = grid[r1][c1] + (r1 !== r2 ? grid[r2][c2] : 0);
                let best = NEG;
                for (const dr1 of [0, 1]) {
                    for (const dr2 of [0, 1]) {
                        const pr1 = r1 - dr1, pr2 = r2 - dr2;
                        if (pr1 >= 0 && pr2 >= 0 && dp[pr1][pr2] !== NEG) {
                            best = Math.max(best, dp[pr1][pr2] + cherries);
                        }
                    }
                }
                ndp[r1][r2] = best;
            }
        }
        dp = ndp;
    }
    return Math.max(0, dp[n - 1][n - 1]);
};
