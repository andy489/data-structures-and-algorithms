// https://leetcode.com/problems/check-balanced-string/

// Solution: Single Pass Sum — O(n) time, O(1) space
var isBalanced = function(num) {
    let diff = 0;
    for (let i = 0; i < num.length; i++) {
        const d = Number(num[i]);
        if (i % 2 === 0) {
            diff += d;
        } else {
            diff -= d;
        }
    }
    return diff === 0;
};
