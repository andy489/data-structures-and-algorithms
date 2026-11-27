// https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
var countElements = function(nums) {
    const mn = Math.min(...nums);
    const mx = Math.max(...nums);
    return nums.filter(x => x > mn && x < mx).length;
};
