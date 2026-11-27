// https://leetcode.com/problems/new-21-game/

var new21Game = function(n, k, maxPts) {
    if (k === 0 || n >= k + maxPts) { return 1.0; }
    const dp = new Array(n + 1).fill(0);
    dp[0] = 1.0;
    let windowSum = 1.0, ans = 0.0;
    for (let i = 1; i <= n; i++) {
        dp[i] = windowSum / maxPts;
        if (i < k) { windowSum += dp[i]; } else { ans += dp[i]; }
        if (i >= maxPts) { windowSum -= dp[i - maxPts]; }
    }
    return ans;
};
