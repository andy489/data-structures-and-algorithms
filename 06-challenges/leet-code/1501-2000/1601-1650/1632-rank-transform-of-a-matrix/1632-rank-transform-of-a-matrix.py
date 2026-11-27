# https://leetcode.com/problems/rank-transform-of-a-matrix/

from collections import defaultdict

class Solution:
    def matrixRankTransform(self, matrix: list[list[int]]) -> list[list[int]]:
        m, n = len(matrix), len(matrix[0])
        ans = [[0] * n for _ in range(m)]
        row_rank = [0] * m
        col_rank = [0] * n

        grouped = defaultdict(list)
        for i in range(m):
            for j in range(n):
                grouped[matrix[i][j]].append((i, j))

        def find(parent, x):
            if parent[x] != x:
                parent[x] = find(parent, parent[x])
            return parent[x]

        def union(parent, x, y):
            px, py = find(parent, x), find(parent, y)
            if px != py:
                parent[px] = py

        for val in sorted(grouped):
            cells = grouped[val]
            parent = list(range(m + n))
            for i, j in cells:
                union(parent, i, m + j)
            root_max = {}
            for i, j in cells:
                root = find(parent, i)
                root_max[root] = max(root_max.get(root, 0), row_rank[i], col_rank[j])
            for i, j in cells:
                rank = root_max[find(parent, i)] + 1
                ans[i][j] = rank
                row_rank[i] = max(row_rank[i], rank)
                col_rank[j] = max(col_rank[j], rank)
        return ans
