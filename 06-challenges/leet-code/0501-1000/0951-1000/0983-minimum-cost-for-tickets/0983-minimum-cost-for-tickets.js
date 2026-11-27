// https://leetcode.com/problems/minimum-cost-for-tickets/

var mincostTickets = function(days, costs) {
    const travel = new Set(days);
    const last = days[days.length - 1];
    const dp = new Array(last + 1).fill(0);
    for (let i = 1; i <= last; i++) {
        if (!travel.has(i)) { dp[i] = dp[i-1]; }
        else {
            dp[i] = Math.min(
                dp[i-1] + costs[0],
                dp[Math.max(0, i-7)] + costs[1],
                dp[Math.max(0, i-30)] + costs[2]
            );
        }
    }
    return dp[last];
};
