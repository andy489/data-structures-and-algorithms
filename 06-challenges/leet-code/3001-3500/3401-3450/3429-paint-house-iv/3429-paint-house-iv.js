// https://leetcode.com/problems/paint-house-iv/

/**
 * @param {number} n
 * @param {number[][]} cost
 * @return {number}
 */
var minCost = function(n, cost) {
    const INF = Infinity;
    let dp = Array.from({length: 3}, () => new Array(3).fill(INF));
    for (let c1 = 0; c1 < 3; c1++) {
        for (let c2 = 0; c2 < 3; c2++) {
            if (c1 !== c2) dp[c1][c2] = cost[0][c1] + cost[n-1][c2];
        }
    }
    for (let i = 1; i < n / 2; i++) {
        const ndp = Array.from({length: 3}, () => new Array(3).fill(INF));
        for (let nc1 = 0; nc1 < 3; nc1++) {
            for (let nc2 = 0; nc2 < 3; nc2++) {
                if (nc1 === nc2) continue;
                for (let pc1 = 0; pc1 < 3; pc1++) {
                    if (pc1 === nc1) continue;
                    for (let pc2 = 0; pc2 < 3; pc2++) {
                        if (pc2 === nc2 || dp[pc1][pc2] === INF) continue;
                        const val = dp[pc1][pc2] + cost[i][nc1] + cost[n-1-i][nc2];
                        if (val < ndp[nc1][nc2]) ndp[nc1][nc2] = val;
                    }
                }
            }
        }
        dp = ndp;
    }
    return Math.min(...dp.flat());
};
