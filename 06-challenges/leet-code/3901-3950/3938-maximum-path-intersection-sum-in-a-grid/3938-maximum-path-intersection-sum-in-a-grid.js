// https://leetcode.com/problems/maximum-path-intersection-sum-in-a-grid/
/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxPathIntersectionSum = function(grid) {
    const m = grid.length;
    const n = grid[0].length;
    const steps = m + n - 2;
    const NEG_INF = -Infinity;

    let dp = Array.from({length: m}, () => new Array(m).fill(NEG_INF));
    dp[0][m - 1] = (m === 1) ? grid[0][0] : 0;

    for (let s = 1; s <= steps; s++) {
        const ndp = Array.from({length: m}, () => new Array(m).fill(NEG_INF));
        const r1Min = Math.max(0, s - (n - 1));
        const r1Max = Math.min(s, m - 1);
        const p2rMin = Math.max(0, m - 1 - s);
        const p2rMax = Math.min(m - 1, m - 1 + n - 1 - s);
        if (p2rMax < 0) {
            continue;
        }
        for (let r1 = r1Min; r1 <= r1Max; r1++) {
            const c1 = s - r1;
            if (c1 < 0 || c1 >= n) {
                continue;
            }
            for (let r2 = p2rMin; r2 <= p2rMax; r2++) {
                const c2 = s - m + 1 + r2;
                if (c2 < 0 || c2 >= n) {
                    continue;
                }
                let best = NEG_INF;
                for (let pr1 = Math.max(0, r1 - 1); pr1 <= r1; pr1++) {
                    for (let pr2 = r2; pr2 <= Math.min(m - 1, r2 + 1); pr2++) {
                        if (dp[pr1][pr2] !== NEG_INF) {
                            best = Math.max(best, dp[pr1][pr2]);
                        }
                    }
                }
                if (best !== NEG_INF) {
                    const add = (r1 === r2 && c1 === c2) ? grid[r1][c1] : 0;
                    ndp[r1][r2] = Math.max(ndp[r1][r2], best + add);
                }
            }
        }
        dp = ndp;
    }

    return dp[m - 1][0];
};
