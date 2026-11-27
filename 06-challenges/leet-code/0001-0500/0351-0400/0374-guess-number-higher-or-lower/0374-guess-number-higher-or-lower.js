// https://leetcode.com/problems/guess-number-higher-or-lower/

// Solution: Binary Search — O(log n) time, O(1) space
var guessNumber = function(n) {
    let lo = 1, hi = n;
    while (lo <= hi) {
        const mid = Math.floor(lo + (hi - lo) / 2);
        const res = guess(mid);
        if (res === 0) return mid;
        else if (res === -1) hi = mid - 1;
        else lo = mid + 1;
    }
    return -1;
};
