// https://leetcode.com/problems/maximum-earnings-from-taxi/

// Solution: DP with Prefix Max — O(m log m + n) time, O(n) space
var maxTaxiEarnings = function(n, rides) {
    rides.sort((a, b) => a[1] - b[1]);
    const dp = new Array(n + 1).fill(0);
    let j = 0;
    for (let i = 1; i <= n; i++) {
        dp[i] = dp[i - 1];
        while (j < rides.length && rides[j][1] === i) {
            const [s, e, t] = rides[j++];
            dp[i] = Math.max(dp[i], dp[s] + t + e - s);
        }
    }
    return dp[n];
};
