// https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/

// Solution: Custom Sort — O(n log n * L) time, O(1) extra space
var kthLargestNumber = function(nums, k) {
    nums.sort((a, b) => {
        if (a.length !== b.length) return a.length - b.length;
        return a < b ? -1 : a > b ? 1 : 0;
    });
    return nums[nums.length - k];
};
