// https://leetcode.com/problems/zero-array-transformation-ii/

// Solution: Binary Search + Difference Array — O((n + q) log q) time, O(n) space
var minZeroArray = function(nums, queries) {
    const n = nums.length;

    function feasible(k) {
        const diff = new Array(n + 1).fill(0);
        for (let i = 0; i < k; i++) {
            const [l, r, val] = queries[i];
            diff[l] += val;
            diff[r + 1] -= val;
        }
        let coverage = 0;
        for (let i = 0; i < n; i++) {
            coverage += diff[i];
            if (coverage < nums[i]) {
                return false;
            }
        }
        return true;
    }

    if (feasible(0)) {
        return 0;
    }
    let lo = 1, hi = queries.length;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (feasible(mid)) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return feasible(lo) ? lo : -1;
};
