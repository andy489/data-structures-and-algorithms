// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/

var minimumSize = function(nums, maxOperations) {
    let lo = 1, hi = Math.max(...nums);
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        let ops = 0;
        for (const n of nums) {
            ops += Math.floor((n - 1) / mid);
        }
        if (ops <= maxOperations) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return lo;
};
