// https://leetcode.com/problems/arithmetic-slices/

var numberOfArithmeticSlices = function(nums) {
    let curr = 0, total = 0;
    for (let i = 2; i < nums.length; i++) {
        if (nums[i] - nums[i - 1] === nums[i - 1] - nums[i - 2]) {
            curr++;
            total += curr;
        } else {
            curr = 0;
        }
    }
    return total;
};
