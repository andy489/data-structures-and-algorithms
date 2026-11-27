// https://leetcode.com/problems/find-k-closest-elements/

var findClosestElements = function(arr, k, x) {
    let lo = 0, hi = arr.length - k;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (x - arr[mid] > arr[mid + k] - x) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }
    return arr.slice(lo, lo + k);
};
