# https://leetcode.com/problems/search-a-2d-matrix/

class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        lo, hi = 0, m * n - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            val = matrix[mid // n][mid % n]
            if val == target:
                return True
            elif val < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return False


# Solution 2: Two Binary Searches — O(log m + log n) time, O(1) space
class Solution2:
    def _find_row(self, matrix: list[list[int]], target: int) -> int:
        # last row index where matrix[i][0] <= target; -1 if none
        lo, hi = 0, len(matrix) - 1
        while lo < hi:
            mid = (lo + hi + 1) // 2
            if matrix[mid][0] <= target:
                lo = mid
            else:
                hi = mid - 1
        return lo if matrix[lo][0] <= target else -1

    def _binary_search(self, arr: list[int], target: int) -> bool:
        # exact search in arr
        lo, hi = 0, len(arr) - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if arr[mid] == target:
                return True
            elif arr[mid] < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return False

    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        # find the last row whose first element <= target
        row = self._find_row(matrix, target)
        if row == -1:
            return False

        # search for target within that row
        return self._binary_search(matrix[row], target)
