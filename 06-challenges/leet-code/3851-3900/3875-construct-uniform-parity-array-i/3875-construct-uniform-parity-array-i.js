// https://leetcode.com/problems/construct-uniform-parity-array-i/

/**
 * @param {number[]} nums1
 * @return {boolean}
 */
var constructArray = function(nums1) {
    let odds = 0, evens = 0;
    for (const x of nums1) {
        if (x % 2 === 0) { evens++; } else { odds++; }
    }
    const allEven = odds === 0 || odds >= 2;
    const allOdd = evens === 0 || odds >= 1;
    return allEven || allOdd;
};
