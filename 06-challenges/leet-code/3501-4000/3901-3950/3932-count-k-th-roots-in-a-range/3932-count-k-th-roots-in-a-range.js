// https://leetcode.com/problems/count-k-th-roots-in-a-range/

/**
 * @param {number} l
 * @param {number} r
 * @param {number} k
 * @return {number}
 */
var countKthRoots = function(l, r, k) {
    if (k === 1) {
        return r - l + 1;
    }
    let count = 0;
    let x = l === 0 ? 0 : 1;
    while (true) {
        const power = Math.pow(x, k);
        if (power > r) {
            break;
        }
        if (power >= l) {
            count++;
        }
        x++;
    }
    return count;
};
