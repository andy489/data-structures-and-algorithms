// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/

var maxValue = function(events, k) {
    events.sort((a, b) => a[1] - b[1]);
    const n = events.length;
    const dp = Array.from({length: n + 1}, () => new Array(k + 1).fill(0));
    for (let i = 1; i <= n; i++) {
        const [start, , val] = events[i - 1];
        // Binary search: last event ending strictly before start
        let lo = 0, hi = i - 1;
        while (lo < hi) {
            const mid = (lo + hi + 1) >> 1;
            if (events[mid - 1][1] < start) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        for (let j = 1; j <= k; j++) {
            dp[i][j] = Math.max(dp[i - 1][j], dp[lo][j - 1] + val);
        }
    }
    return dp[n][k];
};
