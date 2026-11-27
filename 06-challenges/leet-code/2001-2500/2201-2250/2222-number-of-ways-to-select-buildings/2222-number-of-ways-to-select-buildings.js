// https://leetcode.com/problems/number-of-ways-to-select-buildings/
var numberOfWays = function (s) {
    let zeros = 0n, ones = 0n;
    let zeroOne = 0n, oneZero = 0n;
    let result = 0n;
    for (const c of s) {
        if (c === '0') {
            result += zeroOne;
            oneZero += ones;
            zeros++;
        } else {
            result += oneZero;
            zeroOne += zeros;
            ones++;
        }
    }
    return result;
};
