// https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii/

var findIndices = function(nums, indexDifference, valueDifference) {
    let minIdx = 0, maxIdx = 0;
    for (let j = indexDifference; j < nums.length; j++) {
        const i = j - indexDifference;
        if (nums[i] < nums[minIdx]) minIdx = i;
        if (nums[i] > nums[maxIdx]) maxIdx = i;
        if (nums[j] - nums[minIdx] >= valueDifference) return [minIdx, j];
        if (nums[maxIdx] - nums[j] >= valueDifference) return [maxIdx, j];
    }
    return [-1, -1];
};
