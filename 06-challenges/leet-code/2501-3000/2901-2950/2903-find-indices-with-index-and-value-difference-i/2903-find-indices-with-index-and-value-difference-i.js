// https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/

var findIndices = function(nums, indexDifference, valueDifference) {
    const n = nums.length;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (Math.abs(i - j) >= indexDifference
                    && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                return [i, j];
            }
        }
    }
    return [-1, -1];
};
