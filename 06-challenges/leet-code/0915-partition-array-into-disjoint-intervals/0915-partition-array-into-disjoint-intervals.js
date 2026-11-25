// https://leetcode.com/problems/partition-array-into-disjoint-intervals/

var partitionDisjoint = function(nums) {
    const n = nums.length;
    const minRight = new Array(n);
    minRight[n-1] = nums[n-1];
    for (let i = n - 2; i >= 0; i--) minRight[i] = Math.min(nums[i], minRight[i+1]);
    let leftMax = nums[0];
    for (let i = 1; i < n; i++) {
        leftMax = Math.max(leftMax, nums[i-1]);
        if (leftMax <= minRight[i]) return i;
    }
    return n - 1;
};
