# https://leetcode.com/problems/redundant-connection-ii/

class Solution:
    def findRedundantDirectedConnection(self, edges: list) -> list:
        n = len(edges)
        parent_of = [0] * (n + 1)
        cand1 = cand2 = None
        for u, v in edges:
            if parent_of[v]:
                cand1 = [parent_of[v], v]
                cand2 = [u, v]
                break
            parent_of[v] = u

        parent = list(range(n + 1))

        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        for u, v in edges:
            if cand2 and [u, v] == cand2:
                continue
            pu, pv = find(u), find(v)
            if pu == pv:
                return cand1 if cand1 else [u, v]
            parent[pv] = pu
        return cand2
