// https://leetcode.com/problems/minimum-time-to-break-locks-i/

var findMinimumTime = function(strength, k) {
    const n = strength.length;
    const dp = new Array(1 << n).fill(Infinity);
    dp[0] = 0;
    for (let mask = 0; mask < (1 << n); mask++) {
        if (dp[mask] === Infinity) {
            continue;
        }
        const j = mask.toString(2).split('').filter(c => c === '1').length;
        const x = 1 + j * k;
        for (let i = 0; i < n; i++) {
            if (mask & (1 << i)) {
                continue;
            }
            const time = Math.ceil(strength[i] / x);
            const nextMask = mask | (1 << i);
            dp[nextMask] = Math.min(dp[nextMask], dp[mask] + time);
        }
    }
    return dp[(1 << n) - 1];
};
