// https://leetcode.com/problems/optimal-division/
// Solution: Greedy — O(n) time, O(n) space
var optimalDivision = function(nums) {
    const n = nums.length;
    if (n === 1) {
        return String(nums[0]);
    }
    if (n === 2) {
        return `${nums[0]}/${nums[1]}`;
    }
    return `${nums[0]}/(${nums.slice(1).join('/')})`;
};
