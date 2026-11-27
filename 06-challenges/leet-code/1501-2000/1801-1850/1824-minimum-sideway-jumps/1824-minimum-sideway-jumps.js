// https://leetcode.com/problems/minimum-sideway-jumps/

var minSideJumps = function(obstacles) {
    let dp = [1, 0, 1];
    for (let i = 1; i < obstacles.length; i++) {
        const o = obstacles[i] - 1;
        if (o >= 0) dp[o] = Infinity;
        const minCost = Math.min(...dp);
        for (let lane = 0; lane < 3; lane++) {
            if (lane !== o) dp[lane] = Math.min(dp[lane], minCost + 1);
        }
    }
    return Math.min(...dp);
};
