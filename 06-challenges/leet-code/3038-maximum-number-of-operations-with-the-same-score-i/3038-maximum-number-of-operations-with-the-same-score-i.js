// https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/

var maxOperations = function(nums) {
    const target = nums[0] + nums[1];
    let count = 0, i = 0;
    while (i+1 < nums.length && nums[i]+nums[i+1] === target) { count++; i+=2; }
    return count;
};
