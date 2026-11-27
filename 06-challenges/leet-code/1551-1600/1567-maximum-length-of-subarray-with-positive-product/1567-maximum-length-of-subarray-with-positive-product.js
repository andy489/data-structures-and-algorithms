// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/

var getMaxLen = function(nums) {
    let result = 0, start = 0, firstNeg = -1, negCount = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 0) {
            start = i + 1;
            firstNeg = -1;
            negCount = 0;
        } else {
            if (nums[i] < 0) {
                negCount++;
                if (firstNeg === -1) {
                    firstNeg = i;
                }
            }
            if (negCount % 2 === 0) {
                result = Math.max(result, i - start + 1);
            } else {
                result = Math.max(result, i - firstNeg);
            }
        }
    }
    return result;
};
