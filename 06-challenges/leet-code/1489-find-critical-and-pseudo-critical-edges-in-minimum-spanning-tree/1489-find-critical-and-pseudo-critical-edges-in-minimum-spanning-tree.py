# https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/

class Solution:
    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: list[list[int]]) -> list[list[int]]:
        m = len(edges)
        indexed = sorted(range(m), key=lambda i: edges[i][2])
        se = [edges[i] for i in indexed]
        def find(p, x):
            while p[x] != x:
                p[x] = p[p[x]]; x = p[x]
            return x
        def kruskal(skip=-1, force=-1):
            p = list(range(n))
            w = cnt = 0
            if force >= 0:
                a, b = se[force][0], se[force][1]
                p[find(p,a)] = find(p,b); w += se[force][2]; cnt += 1
            for i, (u, v, wt) in enumerate(se):
                if i == skip: continue
                ru, rv = find(p,u), find(p,v)
                if ru != rv:
                    p[ru] = rv; w += wt; cnt += 1
            return w if cnt == n-1 else float('inf')
        base = kruskal()
        crit, pseudo = [], []
        for i in range(m):
            if kruskal(skip=i) > base:
                crit.append(indexed[i])
            elif kruskal(force=i) == base:
                pseudo.append(indexed[i])
        return [crit, pseudo]
