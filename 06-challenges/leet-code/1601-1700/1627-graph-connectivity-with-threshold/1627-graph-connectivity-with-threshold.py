# https://leetcode.com/problems/graph-connectivity-with-threshold/

class Solution:
    def areConnected(self, n: int, threshold: int, queries: list[list[int]]) -> list[bool]:
        parent = list(range(n + 1))
        rank = [0] * (n + 1)

        def find(x: int) -> int:
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        def union(x: int, y: int) -> None:
            px, py = find(x), find(y)
            if px == py:
                return
            if rank[px] < rank[py]:
                parent[px] = py
            elif rank[px] > rank[py]:
                parent[py] = px
            else:
                parent[py] = px
                rank[px] += 1

        for z in range(threshold + 1, n + 1):
            m = 2 * z
            while m <= n:
                union(z, m)
                m += z

        return [find(a) == find(b) for a, b in queries]
