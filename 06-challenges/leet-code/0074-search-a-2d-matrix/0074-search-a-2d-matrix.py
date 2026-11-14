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
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        lo, hi = 0, m - 1
        while lo < hi:
            mid = (lo + hi + 1) // 2
            if matrix[mid][0] <= target:
                lo = mid
            else:
                hi = mid - 1
        if matrix[lo][0] > target:
            return False
        row = lo
        lo, hi = 0, n - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return False
