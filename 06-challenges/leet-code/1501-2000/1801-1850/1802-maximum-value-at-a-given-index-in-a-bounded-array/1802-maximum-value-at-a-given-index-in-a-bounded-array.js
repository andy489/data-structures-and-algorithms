// https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

var maxValue = function(n, index, maxSum) {
    function sumSide(v, len) {
        if (v >= len) {
            const lo = v - len + 1;
            return (v + lo) * len / 2;
        }
        return v * (v + 1) / 2 + (len - v);
    }

    const left = index, right = n - 1 - index;
    let lo = 1, hi = maxSum;
    while (lo < hi) {
        const mid = lo + Math.floor((hi - lo + 1) / 2);
        const total = sumSide(mid, left + 1) + sumSide(mid, right + 1) - mid;
        if (total <= maxSum) {
            lo = mid;
        } else {
            hi = mid - 1;
        }
    }
    return lo;
};
