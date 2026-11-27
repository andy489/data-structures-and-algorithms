// https://leetcode.com/problems/transformed-array/

var constructTransformedArray = function(nums) {
    const n = nums.length;
    const result = new Array(n);
    for (let i = 0; i < n; i++) {
        if (nums[i] === 0) {
            result[i] = 0;
        } else {
            result[i] = nums[((i + nums[i]) % n + n) % n];
        }
    }
    return result;
};
