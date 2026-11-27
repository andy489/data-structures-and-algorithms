// https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/

var connectTwoGroups = function(cost) {
    const m = cost.length, n = cost[0].length;
    const full = (1 << n) - 1;
    const minCostRight = Array.from({length: n}, (_, j) => Math.min(...cost.map(row => row[j])));
    let dp = new Array(1 << n).fill(Infinity);
    dp[0] = 0;
    for (let i = 0; i < m; i++) {
        const ndp = new Array(1 << n).fill(Infinity);
        for (let mask = 0; mask <= full; mask++) {
            if (dp[mask] === Infinity) continue;
            for (let j = 0; j < n; j++) {
                const nmask = mask | (1 << j);
                ndp[nmask] = Math.min(ndp[nmask], dp[mask] + cost[i][j]);
            }
        }
        dp = ndp;
    }
    let result = Infinity;
    for (let mask = 0; mask <= full; mask++) {
        if (dp[mask] === Infinity) continue;
        let extra = 0;
        for (let j = 0; j < n; j++) {
            if (!(mask >> j & 1)) extra += minCostRight[j];
        }
        result = Math.min(result, dp[mask] + extra);
    }
    return result;
};
