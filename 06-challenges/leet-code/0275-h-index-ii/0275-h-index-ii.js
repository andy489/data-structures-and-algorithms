// https://leetcode.com/problems/h-index-ii/

// Solution: Binary Search — O(log n) time, O(1) space
var hIndex = function(citations) {
    const n = citations.length;
    let lo = 0, hi = n;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (citations[mid] >= n - mid) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return n - lo;
};
