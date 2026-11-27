// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/

var findLengthOfShortestSubarray = function(arr) {
    const n = arr.length;
    let r = n - 1;
    while (r > 0 && arr[r] >= arr[r - 1]) {
        r--;
    }
    let result = r;
    let l = 0;
    while (l < r) {
        while (r < n && arr[r] < arr[l]) {
            r++;
        }
        result = Math.min(result, r - l - 1);
        if (arr[l + 1] >= arr[l]) {
            l++;
        } else {
            break;
        }
    }
    return result;
};
