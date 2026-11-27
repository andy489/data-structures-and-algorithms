# https://leetcode.com/problems/n-queens-ii/

# Solution 1: Backtracking with Bitmasks — O(n!) time, O(n) space
class Solution:
    def totalNQueens(self, n: int) -> int:
        full_mask = (1 << n) - 1

        def backtrack(cols: int, diag1: int, diag2: int) -> int:
            if cols == full_mask:
                return 1
            count = 0
            available = ~(cols | diag1 | diag2) & full_mask
            while available:
                bit = available & -available
                count += backtrack(cols | bit, (diag1 | bit) >> 1, (diag2 | bit) << 1)
                available &= available - 1
            return count

        return backtrack(0, 0, 0)


# Solution 2: Backtracking with Sets — O(n!) time, O(n) space
class Solution2:
    def totalNQueens(self, n: int) -> int:
        cols, diag1, diag2 = set(), set(), set()

        def backtrack(row: int) -> int:
            if row == n:
                return 1
            count = 0
            for col in range(n):
                if col in cols or (row - col) in diag1 or (row + col) in diag2:
                    continue
                cols.add(col); diag1.add(row - col); diag2.add(row + col)
                count += backtrack(row + 1)
                cols.remove(col); diag1.remove(row - col); diag2.remove(row + col)
            return count

        return backtrack(0)
