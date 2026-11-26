// https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/

var minimumTimeRequired = function(jobs, k) {
    const n = jobs.length;
    const total = 1 << n;
    const subsetSum = new Array(total).fill(0);
    for (let mask = 1; mask < total; mask++) {
        const lsb = mask & (-mask);
        const bit = Math.log2(lsb);
        subsetSum[mask] = subsetSum[mask ^ lsb] + jobs[bit];
    }

    let dp = subsetSum.slice();
    for (let j = 1; j < k; j++) {
        const ndp = new Array(total).fill(Infinity);
        ndp[0] = 0;
        for (let mask = 1; mask < total; mask++) {
            for (let sub = mask; sub > 0; sub = (sub - 1) & mask) {
                const candidate = Math.max(dp[mask ^ sub], subsetSum[sub]);
                if (candidate < ndp[mask]) {
                    ndp[mask] = candidate;
                }
            }
        }
        dp = ndp;
    }
    return dp[total - 1];
};
