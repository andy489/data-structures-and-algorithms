# https://leetcode.com/problems/construct-2d-grid-matching-graph-layout/

from typing import List


class Solution:
    def constructGridLayout(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        adj = [set() for _ in range(n)]
        for u, v in edges:
            adj[u].add(v)
            adj[v].add(u)
        deg = [len(adj[i]) for i in range(n)]
        min_deg = min(deg)

        start = next(i for i in range(n) if deg[i] == min_deg)

        if min_deg == 1:
            row = [start]
            placed = {start}
            while True:
                cur = row[-1]
                nxt = next((nb for nb in adj[cur] if nb not in placed), None)
                if nxt is None:
                    break
                row.append(nxt)
                placed.add(nxt)
            return [row]

        first_row = [start]
        in_row = {start}
        while True:
            cur = first_row[-1]
            nxt = next((nb for nb in adj[cur] if nb not in in_row and deg[nb] <= min_deg + 1), None)
            if nxt is None:
                break
            first_row.append(nxt)
            in_row.add(nxt)

        cols = len(first_row)
        rows = n // cols
        grid = [[0] * cols for _ in range(rows)]
        for c, v in enumerate(first_row):
            grid[0][c] = v
        placed = set(first_row)

        for r in range(1, rows):
            for c in range(cols):
                above = grid[r - 1][c]
                for nb in adj[above]:
                    if nb not in placed:
                        if c == 0 or grid[r][c - 1] in adj[nb]:
                            grid[r][c] = nb
                            placed.add(nb)
                            break
        return grid
