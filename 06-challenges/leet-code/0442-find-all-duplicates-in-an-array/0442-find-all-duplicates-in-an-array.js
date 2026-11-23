// https://leetcode.com/problems/find-all-duplicates-in-an-array/

var findDuplicates = function(nums) {
    const duplicates = [];
    for (let i = 0; i < nums.length; i++) {
        const idx = Math.abs(nums[i]) - 1;
        if (nums[idx] < 0) {
            duplicates.push(idx + 1);
        } else {
            nums[idx] = -nums[idx];
        }
    }
    return duplicates;
};
