// https://leetcode.com/problems/minimum-division-operations-to-make-array-non-decreasing/

/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function(nums) {
    const maxVal = 1000001;
    const spf = Array.from({length: maxVal}, (_, i) => i);
    for (let i = 2; i * i < maxVal; i++) {
        if (spf[i] === i) {
            for (let j = i * i; j < maxVal; j += i) {
                if (spf[j] === j) {
                    spf[j] = i;
                }
            }
        }
    }
    let ops = 0;
    for (let i = nums.length - 2; i >= 0; i--) {
        if (nums[i] > nums[i + 1]) {
            nums[i] = spf[nums[i]];
            if (nums[i] > nums[i + 1]) {
                return -1;
            }
            ops++;
        }
    }
    return ops;
};
