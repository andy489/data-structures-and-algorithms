// https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/

var containsPattern = function(arr, m, k) {
    const n = arr.length;
    let count = 0;
    for (let i = 0; i + m < n; i++) {
        if (arr[i] !== arr[i + m]) {
            count = 0;
        } else {
            count++;
            if (count === m * (k - 1)) {
                return true;
            }
        }
    }
    return false;
};
