// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
var maxValueOfCoins = function (piles, k) {
    const dp = new Array(k + 1).fill(0);
    for (const pile of piles) {
        const prefix = [0];
        for (const coin of pile) {
            prefix.push(prefix[prefix.length - 1] + coin);
        }
        for (let j = k; j >= 0; j--) {
            for (let take = 1; take <= Math.min(pile.length, j); take++) {
                dp[j] = Math.max(dp[j], dp[j - take] + prefix[take]);
            }
        }
    }
    return dp[k];
};
