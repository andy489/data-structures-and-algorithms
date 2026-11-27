# https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/

class Solution:
    def distanceLimitedPathsExist(self, n: int, edgeList: list[list[int]], queries: list[list[int]]) -> list[bool]:
        parent = list(range(n))
        rank = [0] * n

        def find(x: int) -> int:
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(x: int, y: int) -> None:
            px, py = find(x), find(y)
            if px == py:
                return
            if rank[px] < rank[py]:
                px, py = py, px
            parent[py] = px
            if rank[px] == rank[py]:
                rank[px] += 1

        edgeList.sort(key=lambda e: e[2])
        q = len(queries)
        sorted_q = sorted(range(q), key=lambda i: queries[i][2])
        result = [False] * q
        ei = 0
        for qi in sorted_q:
            limit = queries[qi][2]
            while ei < len(edgeList) and edgeList[ei][2] < limit:
                union(edgeList[ei][0], edgeList[ei][1])
                ei += 1
            result[qi] = find(queries[qi][0]) == find(queries[qi][1])
        return result
