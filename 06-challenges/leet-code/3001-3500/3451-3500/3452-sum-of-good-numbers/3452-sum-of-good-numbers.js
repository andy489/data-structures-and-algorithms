// https://leetcode.com/problems/sum-of-good-numbers/

var sumOfGoodNumbers = function(nums, k) {
    let sum = 0;
    const n = nums.length;
    for (let i = 0; i < n; i++) {
        let good = true;
        if (i - k >= 0 && nums[i] <= nums[i - k]) {
            good = false;
        }
        if (i + k < n && nums[i] <= nums[i + k]) {
            good = false;
        }
        if (good) {
            sum += nums[i];
        }
    }
    return sum;
};
