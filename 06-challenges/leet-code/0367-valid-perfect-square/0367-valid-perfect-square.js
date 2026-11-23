// https://leetcode.com/problems/valid-perfect-square/

// Solution: Binary Search — O(log n) time, O(1) space
var isPerfectSquare = function(num) {
    let lo = 1n, hi = BigInt(num);
    while (lo <= hi) {
        const mid = lo + (hi - lo) / 2n;
        const sq = mid * mid;
        if (sq === BigInt(num)) return true;
        else if (sq < BigInt(num)) lo = mid + 1n;
        else hi = mid - 1n;
    }
    return false;
};
