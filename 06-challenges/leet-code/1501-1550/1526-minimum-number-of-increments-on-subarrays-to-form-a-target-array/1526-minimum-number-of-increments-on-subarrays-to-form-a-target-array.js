// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/

var minNumberOperations = function(target) {
    let ops = target[0];
    for (let i = 1; i < target.length; i++) {
        if (target[i] > target[i - 1]) {
            ops += target[i] - target[i - 1];
        }
    }
    return ops;
};
