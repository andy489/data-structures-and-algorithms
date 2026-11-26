// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/

// Solution: Binary Search — O(m log maxQ) time, O(1) space
var minimizedMaximum = function(n, quantities) {
    let lo = 1, hi = Math.max(...quantities);
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        const stores = quantities.reduce((s, q) => s + Math.ceil(q / mid), 0);
        if (stores <= n) hi = mid; else lo = mid + 1;
    }
    return lo;
};
