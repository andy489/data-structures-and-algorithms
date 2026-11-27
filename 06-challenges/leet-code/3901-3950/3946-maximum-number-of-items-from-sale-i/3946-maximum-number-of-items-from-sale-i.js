// https://leetcode.com/problems/maximum-number-of-items-from-sale-i/

var maximumSaleItems = function(items, budget) {
    const n = items.length;
    const minPrice = Math.min(...items.map(([, p]) => p));

    const free = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (i !== j && items[j][0] % items[i][0] === 0) {
                free[i]++;
            }
        }
    }

    const dp = new Array(budget + 1).fill(0);
    for (let i = 0; i < n; i++) {
        const cost = items[i][1];
        const gain = 1 + free[i];
        for (let b = budget; b >= cost; b--) {
            dp[b] = Math.max(dp[b], dp[b - cost] + gain);
        }
    }

    let ans = 0;
    for (let b = 0; b <= budget; b++) {
        ans = Math.max(ans, dp[b] + Math.floor((budget - b) / minPrice));
    }
    return ans;
};
