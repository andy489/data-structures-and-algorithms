// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

// Solution: Binary Search on Value — O(n log(max-min)) time, O(1) space
var kthSmallest = function(matrix, k) {
    const n = matrix.length;
    const countLE = (mid) => {
        let count = 0, row = 0, col = n - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] <= mid) { count += col + 1; row++; }
            else col--;
        }
        return count;
    };
    let lo = matrix[0][0], hi = matrix[n - 1][n - 1];
    while (lo < hi) {
        const mid = lo + Math.floor((hi - lo) / 2);
        if (countLE(mid) < k) lo = mid + 1;
        else hi = mid;
    }
    return lo;
};
