// https://leetcode.com/problems/find-peak-element/

// Binary search — O(log n) time, O(1) space
var findPeakElement = function(nums) {
    let lo = 0, hi = nums.length - 1;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (nums[mid] < nums[mid + 1]) { lo = mid + 1; }
        else { hi = mid; }
    }
    return lo;
};
