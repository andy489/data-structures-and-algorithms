// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

var numberOfSteps = function(num) {
    let steps = 0;
    while (num > 0) { steps += (num > 1 ? 1 + (num&1) : 1); num >>= 1; }
    return steps;
};
