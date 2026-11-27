// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
var divideArray = function(nums, k) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    const result = [];
    for (let i = 0; i < n; i += 3) {
        if (nums[i + 2] - nums[i] > k) {
            return [];
        }
        result.push([nums[i], nums[i + 1], nums[i + 2]]);
    }
    return result;
};
