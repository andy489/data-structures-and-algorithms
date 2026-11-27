// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

var specialArray = function(nums) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    for (let x = 1; x <= n; x++) {
        let lo = 0, hi = n;
        while (lo < hi) {
            const mid = (lo + hi) >>> 1;
            if (nums[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (n - lo === x) {
            return x;
        }
    }
    return -1;
};
