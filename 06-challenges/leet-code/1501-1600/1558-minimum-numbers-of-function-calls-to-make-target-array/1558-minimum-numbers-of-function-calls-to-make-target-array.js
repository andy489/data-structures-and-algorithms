// https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/

var minOperations = function(nums) {
    let maxBits = 0, adds = 0;
    for (const x of nums) {
        adds += x.toString(2).split('').filter(c => c === '1').length;
        const bits = x === 0 ? 0 : Math.floor(Math.log2(x)) + 1;
        maxBits = Math.max(maxBits, bits);
    }
    return adds + (maxBits > 0 ? maxBits - 1 : 0);
};
