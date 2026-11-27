// https://leetcode.com/problems/patching-array/

var minPatches = function(nums, n) {
    let reach = 0, patches = 0, i = 0;
    while (reach < n) {
        if (i < nums.length && nums[i] <= reach + 1) {
            reach += nums[i++];
        } else {
            reach += reach + 1;
            patches++;
        }
    }
    return patches;
};
