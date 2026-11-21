// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

// Solution: Binary search — O(log n) time, O(1) space
var findMin = function(nums) {
    let lo = 0, hi = nums.length - 1;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (nums[mid] > nums[hi]) lo = mid + 1;
        else hi = mid;
    }
    return nums[lo];
};
