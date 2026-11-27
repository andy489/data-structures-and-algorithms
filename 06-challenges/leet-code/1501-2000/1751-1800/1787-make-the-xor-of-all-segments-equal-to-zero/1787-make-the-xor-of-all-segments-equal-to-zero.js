// https://leetcode.com/problems/make-the-xor-of-all-segments-equal-to-zero/

var minChanges = function(nums, k) {
    const n = nums.length;
    const maxVal = 1 << 10;
    const INF = Infinity;
    let dp = new Array(maxVal).fill(INF);
    dp[0] = 0;

    for (let j = 0; j < k; j++) {
        const cnt = new Map();
        let sz = 0;
        for (let i = j; i < n; i += k) {
            cnt.set(nums[i], (cnt.get(nums[i]) || 0) + 1);
            sz++;
        }
        const globalMin = Math.min(...dp);
        const ndp = new Array(maxVal).fill(globalMin + sz);
        for (let x = 0; x < maxVal; x++) {
            if (dp[x] === INF) continue;
            for (const [v, freq] of cnt) {
                const newXor = x ^ v;
                const cost = dp[x] + sz - freq;
                if (cost < ndp[newXor]) {
                    ndp[newXor] = cost;
                }
            }
        }
        dp = ndp;
    }
    return dp[0];
};
