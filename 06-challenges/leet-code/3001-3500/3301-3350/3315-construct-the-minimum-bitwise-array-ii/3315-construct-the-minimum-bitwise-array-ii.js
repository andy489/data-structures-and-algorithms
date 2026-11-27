// https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var minBitwiseArray = function (nums) {
    return nums.map(p => {
        if (p === 2) {
            return -1;
        }
        for (let bit = 1; bit < 31; bit++) {
            if ((p & (1 << bit)) === 0) {
                const x = p ^ (1 << bit);
                if ((x | (x + 1)) === p) {
                    return x;
                }
            }
        }
        return -1;
    });
};
