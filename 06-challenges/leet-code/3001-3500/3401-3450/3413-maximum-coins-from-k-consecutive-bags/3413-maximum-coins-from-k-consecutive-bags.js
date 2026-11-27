// https://leetcode.com/problems/maximum-coins-from-k-consecutive-bags/
var maximumCoins = function(coins, k) {
    coins.sort((a, b) => a[0] - b[0]);
    const n = coins.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + (coins[i][1] - coins[i][0] + 1) * coins[i][2];
    }

    function coinsInRange(L, R) {
        // Find first segment with right >= L
        let lo = 0, hi = n;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (coins[mid][1] < L) lo = mid + 1;
            else hi = mid;
        }
        const start = lo;

        // Find last segment with left <= R
        lo = 0; hi = n;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (coins[mid][0] <= R) lo = mid + 1;
            else hi = mid;
        }
        const end = lo - 1;

        if (start > end) return 0;

        let total = prefix[end + 1] - prefix[start];
        if (coins[start][0] < L) total -= (L - coins[start][0]) * coins[start][2];
        if (coins[end][1] > R) total -= (coins[end][1] - R) * coins[end][2];
        return total;
    }

    let ans = 0;
    for (let i = 0; i < n; i++) {
        const L = coins[i][0];
        ans = Math.max(ans, coinsInRange(L, L + k - 1));
        const R = coins[i][1];
        ans = Math.max(ans, coinsInRange(R - k + 1, R));
    }
    return ans;
};
