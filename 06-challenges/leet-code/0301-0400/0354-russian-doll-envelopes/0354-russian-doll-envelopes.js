// https://leetcode.com/problems/russian-doll-envelopes/

// Solution: Sort + LIS with Binary Search — O(n log n) time, O(n) space
var maxEnvelopes = function(envelopes) {
    envelopes.sort((a, b) => a[0] !== b[0] ? a[0] - b[0] : b[1] - a[1]);
    const tails = [];
    for (const [, h] of envelopes) {
        let lo = 0, hi = tails.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (tails[mid] < h) lo = mid + 1;
            else hi = mid;
        }
        tails[lo] = h;
    }
    return tails.length;
};
