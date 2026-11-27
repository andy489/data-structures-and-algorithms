// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
var minBitFlips = function (start, goal) {
    let xor = start ^ goal;
    let count = 0;
    while (xor > 0) {
        count += xor & 1;
        xor >>= 1;
    }
    return count;
};
