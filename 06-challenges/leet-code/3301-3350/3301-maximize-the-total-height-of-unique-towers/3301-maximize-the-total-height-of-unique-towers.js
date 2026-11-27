// https://leetcode.com/problems/maximize-the-total-height-of-unique-towers/

/**
 * @param {number[]} maximumHeight
 * @return {number}
 */
var maximumTotalSum = function (maximumHeight) {
    maximumHeight.sort((a, b) => a - b);
    const n = maximumHeight.length;
    let result = BigInt(maximumHeight[n - 1]);
    let prev = maximumHeight[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        const h = Math.min(maximumHeight[i], prev - 1);
        if (h < 1) {
            return -1;
        }
        result += BigInt(h);
        prev = h;
    }
    return Number(result);
};
