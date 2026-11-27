// https://leetcode.com/problems/minimum-operations-to-make-a-subsequence/

var minOperations = function(target, arr) {
    const posInTarget = new Map();
    for (let i = 0; i < target.length; i++) {
        posInTarget.set(target[i], i);
    }
    const indices = [];
    for (const v of arr) {
        if (posInTarget.has(v)) {
            indices.push(posInTarget.get(v));
        }
    }
    const tails = [];
    for (const idx of indices) {
        let lo = 0, hi = tails.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (tails[mid] < idx) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        tails[lo] = idx;
    }
    return target.length - tails.length;
};
