// https://leetcode.com/problems/search-a-2d-matrix/

// Solution: Binary Search on Flattened Matrix — O(log(m·n)) time, O(1) space
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int val = matrix[mid / n][mid % n];
            if (val == target) {
                return true;
            } else if (val < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}

// Solution 2: Two Binary Searches — O(log m + log n) time, O(1) space
class Solution2 {
    // last row index in [lo, hi] where matrix[i][0] <= target; returns -1 if none
    private int findRow(int[][] matrix, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (matrix[mid][0] <= target) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return matrix[lo][0] <= target ? lo : -1;
    }

    // exact binary search in arr[lo..hi]; returns true if target found
    private boolean binarySearch(int[] arr, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        // find the last row whose first element <= target
        int row = findRow(matrix, 0, m - 1, target);
        if (row == -1) {
            return false;
        }

        // search for target within that row
        return binarySearch(matrix[row], 0, n - 1, target);
    }
}
