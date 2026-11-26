// https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/

var preimageSizeFZF = function(k) {
    function trailingZeroes(x) {
        let count = 0;
        while (x >= 5) { x = Math.floor(x / 5); count += x; }
        return count;
    }
    function leftBound(k) {
        let lo = 0, hi = 5 * (k + 1);
        while (lo < hi) {
            const mid = Math.floor((lo + hi) / 2);
            if (trailingZeroes(mid) <= k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    return leftBound(k) - leftBound(k - 1);
};
