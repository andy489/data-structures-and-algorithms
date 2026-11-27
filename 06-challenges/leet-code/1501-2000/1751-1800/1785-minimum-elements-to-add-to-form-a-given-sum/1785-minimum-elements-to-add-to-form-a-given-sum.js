// https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/

var minElements = function(nums, limit, goal) {
    const sum = nums.reduce((acc, x) => acc + x, 0);
    const diff = Math.abs(goal - sum);
    return Math.ceil(diff / limit);
};
