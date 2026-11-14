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
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (matrix[mid][0] <= target) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        if (matrix[lo][0] > target) {
            return false;
        }
        int row = lo;
        lo = 0; hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
