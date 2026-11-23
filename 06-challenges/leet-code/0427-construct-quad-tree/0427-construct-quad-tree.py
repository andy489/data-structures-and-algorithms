# https://leetcode.com/problems/construct-quad-tree/

class Solution:
    def construct(self, grid: list[list[int]]) -> 'Node':
        n = len(grid)
        prefix = [[0] * (n + 1) for _ in range(n + 1)]
        for r in range(n):
            for c in range(n):
                prefix[r + 1][c + 1] = (grid[r][c]
                    + prefix[r][c + 1]
                    + prefix[r + 1][c]
                    - prefix[r][c])

        def range_sum(r1, c1, r2, c2):
            return (prefix[r2 + 1][c2 + 1]
                  - prefix[r1][c2 + 1]
                  - prefix[r2 + 1][c1]
                  + prefix[r1][c1])

        def build(row, col, size):
            total = range_sum(row, col, row + size - 1, col + size - 1)
            if total == 0:
                return Node(False, True)
            if total == size * size:
                return Node(True, True)
            half = size // 2
            return Node(
                True, False,
                build(row, col, half),
                build(row, col + half, half),
                build(row + half, col, half),
                build(row + half, col + half, half)
            )

        return build(0, 0, n)
