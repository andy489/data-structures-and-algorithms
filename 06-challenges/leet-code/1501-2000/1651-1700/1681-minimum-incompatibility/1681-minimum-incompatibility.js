// https://leetcode.com/problems/minimum-incompatibility/

var minimumIncompatibility = function(nums, k) {
    const n = nums.length;
    const groupSize = n / k;
    const full = (1 << n) - 1;

    function bitCount(x) {
        let count = 0;
        while (x) {
            x &= x - 1;
            count++;
        }
        return count;
    }

    const cost = new Array(full + 1).fill(-1);
    for (let mask = 1; mask <= full; mask++) {
        if (bitCount(mask) !== groupSize) {
            continue;
        }
        const vals = [];
        let valid = true;
        const freq = new Array(n + 1).fill(0);
        for (let i = 0; i < n; i++) {
            if ((mask >> i) & 1) {
                if (++freq[nums[i]] > 1) {
                    valid = false;
                    break;
                }
                vals.push(nums[i]);
            }
        }
        if (valid) {
            cost[mask] = Math.max(...vals) - Math.min(...vals);
        }
    }

    const dp = new Array(full + 1).fill(Infinity);
    dp[0] = 0;
    for (let mask = 0; mask <= full; mask++) {
        if (dp[mask] === Infinity) {
            continue;
        }
        const remaining = full ^ mask;
        for (let sub = remaining; sub > 0; sub = (sub - 1) & remaining) {
            if (cost[sub] !== -1) {
                dp[mask | sub] = Math.min(dp[mask | sub], dp[mask] + cost[sub]);
            }
        }
    }
    return dp[full] === Infinity ? -1 : dp[full];
};
