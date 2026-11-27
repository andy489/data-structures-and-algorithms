// https://leetcode.com/problems/maximize-subarray-sum-after-removing-all-occurrences-of-one-element/
var maximumSumSubarray = function(nums) {
    function kadane(skip) {
        let cur = 0, best = -Infinity, hasElement = false;
        for (const v of nums) {
            if (v === skip) continue;
            hasElement = true;
            cur += v;
            if (cur > best) best = cur;
            if (cur < 0) cur = 0;
        }
        return hasElement ? best : -Infinity;
    }

    let ans = kadane(null);
    const negatives = new Set(nums.filter(x => x < 0));
    for (const x of negatives) {
        const val = kadane(x);
        if (val > ans) ans = val;
    }
    return ans;
};
