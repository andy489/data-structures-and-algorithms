// https://leetcode.com/problems/first-unique-even-element/

/**
 * @param {number[]} nums
 * @return {number}
 */
var firstUniqueEvenElement = function(nums) {
    const freq = new Map();
    for (const n of nums) {
        freq.set(n, (freq.get(n) || 0) + 1);
    }
    for (const n of nums) {
        if (n % 2 === 0 && freq.get(n) === 1) {
            return n;
        }
    }
    return -1;
};
