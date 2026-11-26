// https://leetcode.com/problems/last-stone-weight-ii/

var lastStoneWeightII = function(stones) {
    const total = stones.reduce((a, b) => a + b, 0);
    const target = Math.floor(total / 2);
    const dp = new Array(target + 1).fill(false);
    dp[0] = true;
    for (const s of stones) {
        for (let j = target; j >= s; j--) {
            dp[j] = dp[j] || dp[j-s];
        }
    }
    for (let j = target; j >= 0; j--) {
        if (dp[j]) return total - 2*j;
    }
    return total;
};
