// https://leetcode.com/problems/sum-of-k-subarrays-with-length-at-least-m/

var maxSum = function(nums, k, m) {
    const n = nums.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }
    const NEG_INF = -Infinity;
    let prev = new Array(n + 1).fill(NEG_INF);
    prev[0] = 0;

    for (let j = 1; j <= k; j++) {
        const curr = new Array(n + 1).fill(NEG_INF);
        let best = NEG_INF;
        for (let i = m; i <= n; i++) {
            const s = i - m;
            if (prev[s] !== NEG_INF) {
                best = Math.max(best, prev[s] - prefix[s]);
            }
            if (best !== NEG_INF) {
                curr[i] = Math.max(curr[i], best + prefix[i]);
            }
            if (i > 0 && curr[i - 1] !== NEG_INF) {
                curr[i] = Math.max(curr[i], curr[i - 1]);
            }
        }
        prev = curr;
    }
    return prev[n];
};
