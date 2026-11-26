# https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/

from collections import defaultdict

class Solution:
    def checkWays(self, pairs: list[list[int]]) -> int:
        adj = defaultdict(set)
        for x, y in pairs:
            adj[x].add(y)
            adj[y].add(x)

        n = len(adj)
        nodes = sorted(adj.keys(), key=lambda u: len(adj[u]))
        multiple = False

        for u in nodes:
            u_adj = adj[u]
            deg_u = len(u_adj) + 1

            # Find parent: smallest-degree neighbor with degree >= deg_u
            parent = -1
            min_deg = float('inf')
            for v in u_adj:
                deg_v = len(adj[v]) + 1
                if deg_v >= deg_u and deg_v < min_deg:
                    min_deg = deg_v
                    parent = v

            if parent == -1:
                if deg_u != n:
                    return 0
            else:
                p_adj = adj[parent]
                for v in u_adj:
                    if v != parent and v not in p_adj:
                        return 0
                if len(adj[parent]) == len(u_adj):
                    multiple = True

        return 2 if multiple else 1
