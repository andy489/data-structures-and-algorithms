// https://leetcode.com/problems/search-a-2d-matrix/

var searchMatrix = function(matrix, target) {
    const m = matrix.length, n = matrix[0].length;
    let lo = 0, hi = m * n - 1;
    while (lo <= hi) {
        const mid = (lo + hi) >> 1;
        const val = matrix[Math.floor(mid / n)][mid % n];
        if (val === target) {
            return true;
        } else if (val < target) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return false;
};

// Solution 2: Two Binary Searches — O(log m + log n) time, O(1) space
var searchMatrix2 = function(matrix, target) {
    // last index i where arr[i] <= target; -1 if none
    function upperFloor(arr, target) {
        let lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            const mid = (lo + hi + 1) >> 1;
            if (arr[mid] <= target) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return arr[lo] <= target ? lo : -1;
    }

    // exact search in arr
    function binarySearch(arr, target) {
        let lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            const mid = (lo + hi) >> 1;
            if (arr[mid] === target) {
                return true;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    // find the last row whose first element <= target
    const firstCols = matrix.map(r => r[0]);
    const row = upperFloor(firstCols, target);
    if (row === -1) {
        return false;
    }

    // search for target within that row
    return binarySearch(matrix[row], target);
};
