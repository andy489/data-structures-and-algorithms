// https://leetcode.com/problems/sqrtx/

// Solution: Binary Search — O(log x) time, O(1) space
var mySqrt = function(x) {
    if (x < 2) {
        return x;
    }
    let lo = 1, hi = Math.floor(x / 2);
    while (lo <= hi) {
        const mid = lo + Math.floor((hi - lo) / 2);
        const sq = mid * mid;
        if (sq === x) {
            return mid;
        } else if (sq < x) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return hi;
};
