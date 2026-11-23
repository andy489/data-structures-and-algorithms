// https://leetcode.com/problems/first-bad-version/

// Solution: Binary Search — O(log n) time, O(1) space
var solution = function(isBadVersion) {
    return function(n) {
        let lo = 1, hi = n;
        while (lo < hi) {
            const mid = lo + Math.floor((hi - lo) / 2);
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    };
};
