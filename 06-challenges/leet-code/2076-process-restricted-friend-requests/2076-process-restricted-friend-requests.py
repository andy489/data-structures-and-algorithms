# https://leetcode.com/problems/process-restricted-friend-requests/

class Solution:
    def friendRequests(self, n: int, restrictions: list[list[int]], requests: list[list[int]]) -> list[bool]:
        parent = list(range(n))
        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x
        def union(a, b):
            parent[find(a)] = find(b)
        res = []
        for u, v in requests:
            ru, rv = find(u), find(v)
            if ru == rv:
                res.append(True)
                continue
            ok = all(not ((find(x) == ru and find(y) == rv) or (find(x) == rv and find(y) == ru))
                     for x, y in restrictions)
            if ok:
                union(ru, rv)
            res.append(ok)
        return res
