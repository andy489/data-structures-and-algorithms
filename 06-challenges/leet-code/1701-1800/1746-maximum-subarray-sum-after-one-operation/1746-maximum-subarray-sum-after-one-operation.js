// https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/

var maxSumAfterOperation = function(nums) {
    let noSq = nums[0];
    let withSq = nums[0] * nums[0];
    let ans = withSq;
    for (let i = 1; i < nums.length; i++) {
        const v = nums[i];
        const newWithSq = Math.max(noSq + v * v, withSq + v, v * v);
        noSq = Math.max(noSq + v, v);
        withSq = newWithSq;
        ans = Math.max(ans, withSq);
    }
    return ans;
};
