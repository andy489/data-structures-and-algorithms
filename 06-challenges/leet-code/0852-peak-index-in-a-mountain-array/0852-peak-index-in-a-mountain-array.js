// https://leetcode.com/problems/peak-index-in-a-mountain-array/

var peakIndexInMountainArray = function(arr) {
    let lo = 0, hi = arr.length - 1;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (arr[mid] < arr[mid + 1]) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }
    return lo;
};
