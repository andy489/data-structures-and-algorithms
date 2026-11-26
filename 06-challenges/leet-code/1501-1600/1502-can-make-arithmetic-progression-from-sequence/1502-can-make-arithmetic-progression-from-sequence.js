// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

var canMakeArithmeticProgression = function(arr) {
    arr.sort((a, b) => a - b);
    const diff = arr[1] - arr[0];
    for (let i = 2; i < arr.length; i++) {
        if (arr[i] - arr[i - 1] !== diff) return false;
    }
    return true;
};
