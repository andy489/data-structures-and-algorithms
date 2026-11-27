// https://leetcode.com/problems/race-car/

var racecar = function(target) {
    const dp = new Array(target + 1).fill(0);
    for (let t = 1; t <= target; t++) {
        const k = Math.floor(Math.log2(t)) + 1;
        if (t === (1 << k) - 1) { dp[t] = k; continue; }
        dp[t] = dp[(1 << k) - 1 - t] + k + 1;
        for (let j = 0; j < k - 1; j++) {
            const back = (1 << j) - 1;
            dp[t] = Math.min(dp[t], dp[t - (1 << (k - 1)) + 1 + back] + k - 1 + j + 2);
        }
    }
    return dp[target];
};
