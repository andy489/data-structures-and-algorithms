// https://leetcode.com/problems/zero-array-transformation-iv/

var minZeroArray = function(nums, queries) {
    const n = nums.length, q = queries.length;

    const canZero = (k) => {
        for (let i = 0; i < n; i++) {
            if (nums[i] === 0) continue;
            const target = nums[i];
            const dp = new Array(target + 1).fill(false);
            dp[0] = true;
            for (let j = 0; j < k; j++) {
                const [l, r, val] = queries[j];
                if (l <= i && i <= r) {
                    for (let s = target; s >= val; s--) {
                        if (dp[s - val]) dp[s] = true;
                    }
                }
            }
            if (!dp[target]) return false;
        }
        return true;
    };

    let lo = 0, hi = q, ans = -1;
    while (lo <= hi) {
        const mid = (lo + hi) >> 1;
        if (canZero(mid)) { ans = mid; hi = mid - 1; }
        else lo = mid + 1;
    }
    return ans;
};
