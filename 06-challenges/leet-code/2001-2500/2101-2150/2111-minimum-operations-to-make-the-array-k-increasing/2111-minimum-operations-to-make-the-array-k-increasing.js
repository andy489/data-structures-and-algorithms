// https://leetcode.com/problems/minimum-operations-to-make-the-array-k-increasing/

// Solution: LNDS on each stride — O(n log n) time, O(n) space
var kIncreasing = function(arr, k) {
    function lnds(seq) {
        const tails = [];
        for (const x of seq) {
            // Binary search for first tail strictly greater than x
            let lo = 0, hi = tails.length;
            while (lo < hi) {
                const mid = (lo + hi) >> 1;
                if (tails[mid] <= x) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if (lo === tails.length) {
                tails.push(x);
            } else {
                tails[lo] = x;
            }
        }
        return tails.length;
    }

    let ops = 0;
    for (let r = 0; r < k; r++) {
        const sub = [];
        for (let i = r; i < arr.length; i += k) {
            sub.push(arr[i]);
        }
        ops += sub.length - lnds(sub);
    }
    return ops;
};
