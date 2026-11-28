// https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/

var lenOfVDiagonal = function(grid) {
    const n = grid.length, m = grid[0].length;
    const dirs = [[1, 1], [1, -1], [-1, 1], [-1, -1]];
    const clockwise = [1, 3, 0, 2];
    // dp[r][c][d][t]
    const dp = Array.from({length: n}, () =>
        Array.from({length: m}, () =>
            Array.from({length: 4}, () => [0, 0])
        )
    );
    let ans = 0;

    for (let r = 0; r < n; r++) {
        for (let c = 0; c < m; c++) {
            if (grid[r][c] === 1) {
                for (let d = 0; d < 4; d++) {
                    dp[r][c][d][0] = 1;
                    dp[r][c][d][1] = 1;
                }
                ans = Math.max(ans, 1);
            }
        }
    }

    for (let pass = 0; pass < 2; pass++) {
        for (let r = 0; r < n; r++) {
            for (let c = 0; c < m; c++) {
                for (let d = 0; d < 4; d++) {
                    const [dr, dc] = dirs[d];
                    const pr = r - dr, pc = c - dc;
                    if (pr >= 0 && pr < n && pc >= 0 && pc < m) {
                        if (dp[pr][pc][d][0] > 0) {
                            const expected = dp[pr][pc][d][0] % 2 === 1 ? 2 : 0;
                            if (grid[r][c] === expected) {
                                const nl = dp[pr][pc][d][0] + 1;
                                if (nl > dp[r][c][d][0]) { dp[r][c][d][0] = nl; ans = Math.max(ans, nl); }
                            }
                        }
                        const td = clockwise[d];
                        if (dp[pr][pc][td][1] > 0) {
                            const expected2 = dp[pr][pc][td][1] % 2 === 1 ? 2 : 0;
                            if (grid[r][c] === expected2) {
                                const nl = dp[pr][pc][td][1] + 1;
                                if (nl > dp[r][c][d][1]) { dp[r][c][d][1] = nl; ans = Math.max(ans, nl); }
                            }
                        }
                    }
                }
            }
        }
    }
    return ans;
};
