// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/
var minOperations = function(nums, k) {
    let xorAll = 0;
    for (const num of nums) {
        xorAll ^= num;
    }
    let diff = xorAll ^ k;
    let count = 0;
    while (diff > 0) {
        count += diff & 1;
        diff >>= 1;
    }
    return count;
};
