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
    const m = matrix.length, n = matrix[0].length;
    let lo = 0, hi = m - 1;
    while (lo < hi) {
        const mid = (lo + hi + 1) >> 1;
        if (matrix[mid][0] <= target) {
            lo = mid;
        } else {
            hi = mid - 1;
        }
    }
    if (matrix[lo][0] > target) {
        return false;
    }
    const row = lo;
    lo = 0; hi = n - 1;
    while (lo <= hi) {
        const mid = (lo + hi) >> 1;
        if (matrix[row][mid] === target) {
            return true;
        } else if (matrix[row][mid] < target) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return false;
};
