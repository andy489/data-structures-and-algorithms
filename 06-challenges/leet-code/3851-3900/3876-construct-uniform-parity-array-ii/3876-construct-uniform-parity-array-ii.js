// https://leetcode.com/problems/construct-uniform-parity-array-ii/

/**
 * @param {number[]} nums1
 * @return {boolean}
 */
var constructArray = function(nums1) {
    let minOdd = Infinity, minEven = Infinity;
    for (const x of nums1) {
        if (x % 2 !== 0) { minOdd = Math.min(minOdd, x); }
        else { minEven = Math.min(minEven, x); }
    }
    const allEven = minOdd === Infinity;
    const allOdd = minEven === Infinity || (minOdd !== Infinity && minOdd < minEven);
    return allEven || allOdd;
};
