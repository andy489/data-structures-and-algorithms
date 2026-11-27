// https://leetcode.com/problems/find-triangular-sum-of-an-array/
var triangularSum = function (nums) {
    let n = nums.length;
    while (n > 1) {
        for (let i = 0; i < n - 1; i++) {
            nums[i] = (nums[i] + nums[i + 1]) % 10;
        }
        n--;
    }
    return nums[0];
};
