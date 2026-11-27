// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

// Solution: Binary search with duplicate handling — O(n) worst, O(log n) avg, O(1) space
var findMin = function(nums) {
    let lo = 0, hi = nums.length - 1;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (nums[mid] > nums[hi]) lo = mid + 1;
        else if (nums[mid] < nums[hi]) hi = mid;
        else hi--;
    }
    return nums[lo];
};
