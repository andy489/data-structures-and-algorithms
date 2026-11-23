// https://leetcode.com/problems/single-number-iii/

// Solution: Bit Manipulation (XOR + partition) — O(n) time, O(1) space
var singleNumber = function(nums) {
    let xor = 0;
    for (const n of nums) xor ^= n;
    const mask = xor & (-xor);
    let a = 0;
    for (const n of nums) {
        if (n & mask) a ^= n;
    }
    return [a, xor ^ a];
};
