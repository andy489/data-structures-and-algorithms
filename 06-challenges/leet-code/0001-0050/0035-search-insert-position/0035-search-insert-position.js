// https://leetcode.com/problems/search-insert-position/

// Solution: Binary Search (Lower Bound) — O(log n) time, O(1) space
var searchInsert = function(nums, target) {
    let lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        const mid = lo + Math.floor((hi - lo) / 2);
        if (nums[mid] === target) {
            return mid;
        } else if (nums[mid] < target) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return lo;
};
