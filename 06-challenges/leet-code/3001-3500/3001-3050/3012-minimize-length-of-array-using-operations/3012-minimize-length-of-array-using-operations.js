// https://leetcode.com/problems/minimize-length-of-array-using-operations/

var minimumArrayLength = function(nums) {
    const mn = Math.min(...nums);
    return nums.filter(x => x % mn !== 0).length + 1;
};
