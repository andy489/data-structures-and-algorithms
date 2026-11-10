// https://leetcode.com/problems/sqrtx/

// Solution 1: Binary Search — O(log x) time, O(1) space
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

// Solution 2: Newton's Method, integer — O(log log x) time, O(1) space
// Implicit epsilon = 1: stop when r*r <= x (r can't get closer than 1 in integer arithmetic)
// r_next = (r + x/r) / 2  converges quadratically; AM-GM guarantees r >= sqrt(x) always
var mySqrt2 = function(x) {
    if (x === 0) {
        return 0;
    }
    let r = x;
    while (r * r > x) {
        r = Math.floor((r + Math.floor(x / r)) / 2);
    }
    return r;
};

// Solution 3: Newton's Method, floating-point with explicit epsilon — O(log log(x/eps)) time, O(1) space
// General version: stop when |r*r - x| < eps.
// eps = 1e-5 gives 5 decimal places of precision; each extra decimal place costs ~1 iteration.
var mySqrt3 = function(x, eps = 1e-5) {
    if (x === 0) {
        return 0;
    }
    let r = x;
    while (Math.abs(r * r - x) > eps) {
        r = (r + x / r) / 2.0;
    }
    return r;
};
