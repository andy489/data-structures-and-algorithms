// https://leetcode.com/problems/sqrtx/

// Solution 1: Binary Search, integer — O(log x) time, O(1) space
// Implicit epsilon = 1: search space shrinks by half each step; stops at floor(sqrt(x))
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

// Machine epsilon for JS number (IEEE 754 double): 2^-52 ≈ 2.22e-16
const MACHINE_EPS = Number.EPSILON; // 2^-52

// Solution 3: Binary Search, floating-point with explicit epsilon — O(log(x/eps)) time, O(1) space
// General version: narrow [lo, hi] until hi - lo < eps.
// eps = 1e-5 gives 5 decimal places; each extra decimal place doubles the iterations (~log2(10) ≈ 3.3 more steps).
//
// Validation:
//   x   >= 0           : sqrt of a negative number is undefined in reals
//   eps >= Number.EPSILON : below machine epsilon (~2.2e-16) adjacent doubles are
//                          indistinguishable and the loop may never converge
var mySqrt3 = function(x, eps = 1e-5) {
    if (x < 0) {
        throw new RangeError(`x must be non-negative, got: ${x}`);
    }
    if (eps < MACHINE_EPS) {
        throw new RangeError(`eps must be >= machine epsilon (${MACHINE_EPS}), got: ${eps}`);
    }
    if (x === 0) {
        return 0;
    }
    let lo = 0, hi = Math.max(1, x);
    while (hi - lo > eps) {
        const mid = lo + (hi - lo) / 2.0;
        if (mid * mid <= x) {
            lo = mid;
        } else {
            hi = mid;
        }
    }
    return lo;
};

// Solution 4: Newton's Method, floating-point with explicit epsilon — O(log log(x/eps)) time, O(1) space
// General version: stop when |r*r - x| < eps.
// eps = 1e-5 gives 5 decimal places; each extra decimal place costs ~1 iteration (quadratic convergence).
//
// Validation:
//   x   >= 0           : sqrt of a negative number is undefined in reals
//   eps >= Number.EPSILON : below machine epsilon the stopping condition |r*r - x| > eps
//                          may never be satisfied due to floating-point rounding
var mySqrt4 = function(x, eps = 1e-5) {
    if (x < 0) {
        throw new RangeError(`x must be non-negative, got: ${x}`);
    }
    if (eps < MACHINE_EPS) {
        throw new RangeError(`eps must be >= machine epsilon (${MACHINE_EPS}), got: ${eps}`);
    }
    if (x === 0) {
        return 0;
    }
    let r = x;
    while (Math.abs(r * r - x) > eps) {
        r = (r + x / r) / 2.0;
    }
    return r;
};
