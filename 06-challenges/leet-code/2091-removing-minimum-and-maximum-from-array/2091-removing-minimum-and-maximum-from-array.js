// https://leetcode.com/problems/removing-minimum-and-maximum-from-array/

// Solution: Three-Way Comparison — O(n) time, O(1) space
var minimumDeletions = function(nums) {
    const n = nums.length;
    let minI = 0, maxI = 0;
    for (let i = 1; i < n; i++) {
        if (nums[i] < nums[minI]) minI = i;
        if (nums[i] > nums[maxI]) maxI = i;
    }
    const left = Math.max(minI, maxI) + 1;
    const right = n - Math.min(minI, maxI);
    const both = Math.min(minI, maxI) + 1 + n - Math.max(minI, maxI);
    return Math.min(left, right, both);
};
