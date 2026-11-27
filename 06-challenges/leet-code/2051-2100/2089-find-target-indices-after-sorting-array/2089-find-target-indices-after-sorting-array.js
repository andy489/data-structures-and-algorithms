// https://leetcode.com/problems/find-target-indices-after-sorting-array/

// Solution: Count Less and Equal — O(n) time, O(1) space
var targetIndices = function(nums, target) {
    const less = nums.filter(x => x < target).length;
    const equal = nums.filter(x => x === target).length;
    return Array.from({length: equal}, (_, i) => less + i);
};
