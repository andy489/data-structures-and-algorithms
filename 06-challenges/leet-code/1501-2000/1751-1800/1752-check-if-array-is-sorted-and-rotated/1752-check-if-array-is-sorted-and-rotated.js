// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

var check = function(nums) {
    const n = nums.length;
    let descents = 0;
    for (let i = 0; i < n; i++) {
        if (nums[i] > nums[(i + 1) % n]) {
            descents++;
        }
    }
    return descents <= 1;
};
