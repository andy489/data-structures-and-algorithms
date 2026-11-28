// https://leetcode.com/problems/find-the-number-of-copy-arrays/

var countArrays = function(original, bounds) {
    let lo = -Infinity, hi = Infinity;
    for (let i = 0; i < original.length; i++) {
        const diff = original[i] - original[0];
        lo = Math.max(lo, bounds[i][0] - diff);
        hi = Math.min(hi, bounds[i][1] - diff);
    }
    return Math.max(0, hi - lo + 1);
};
