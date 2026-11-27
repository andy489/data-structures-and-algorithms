// https://leetcode.com/problems/wiggle-sort-ii/

// Solution: Sort + Interleave — O(n log n) time, O(n) space
var wiggleSort = function(nums) {
    const n = nums.length;
    const sorted = [...nums].sort((a, b) => a - b);
    let mid = Math.floor((n - 1) / 2);
    let large = n - 1;
    for (let i = 0; i < n; i++) {
        nums[i] = i % 2 === 0 ? sorted[mid--] : sorted[large--];
    }
};
