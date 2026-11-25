// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/

var findKthNumber = function(m, n, k) {
    function count(x) {
        let cnt = 0;
        for (let i = 1; i <= m; i++) cnt += Math.min(Math.floor(x / i), n);
        return cnt;
    }
    let lo = 1, hi = m * n;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (count(mid) >= k) hi = mid;
        else lo = mid + 1;
    }
    return lo;
};
