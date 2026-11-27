// https://leetcode.com/problems/count-digit-appearances/
/**
 * @param {number[]} nums
 * @param {number} digit
 * @return {number}
 */
var countDigitAppearances = function(nums, digit) {
    const target = String(digit);
    let count = 0;
    for (const num of nums) {
        const s = String(num);
        for (const c of s) {
            if (c === target) {
                count++;
            }
        }
    }
    return count;
};
