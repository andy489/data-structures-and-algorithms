// https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/

var largestNumber = function(cost, target) {
    const dp = new Array(target+1).fill(-Infinity); dp[0] = 0;
    for (let t = 1; t <= target; t++)
        for (let d = 0; d < 9; d++)
            if (cost[d] <= t && dp[t-cost[d]] !== -Infinity)
                dp[t] = Math.max(dp[t], dp[t-cost[d]]+1);
    if (dp[target] < 0) return "0";
    let res = "", rem = target;
    while (rem > 0) {
        for (let d = 8; d >= 0; d--) {
            if (cost[d] <= rem && dp[rem-cost[d]] === dp[rem]-1) {
                res += (d+1); rem -= cost[d]; break;
            }
        }
    }
    return res;
};
