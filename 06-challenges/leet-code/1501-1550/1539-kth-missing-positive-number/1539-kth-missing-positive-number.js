// https://leetcode.com/problems/kth-missing-positive-number/

var findKthPositive = function(arr, k) {
    let lo = 0, hi = arr.length;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (arr[mid] - (mid + 1) >= k) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return lo + k;
};
