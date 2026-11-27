// https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/
var missingInteger = function(nums) {
    let sum = nums[0];
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] === nums[i - 1] + 1) {
            sum += nums[i];
        } else {
            break;
        }
    }
    const seen = new Set(nums);
    while (seen.has(sum)) {
        sum++;
    }
    return sum;
};
