# https://leetcode.com/problems/minimum-height-trees/

class Solution:
    def findMinHeightTrees(self, n: int, edges: list[list[int]]) -> list[int]:
        if n == 1:
            return [0]
        adj = [set() for _ in range(n)]
        for u, v in edges:
            adj[u].add(v)
            adj[v].add(u)
        leaves = [i for i in range(n) if len(adj[i]) == 1]
        remaining = n
        while remaining > 2:
            remaining -= len(leaves)
            new_leaves = []
            for leaf in leaves:
                nb = next(iter(adj[leaf]))
                adj[nb].remove(leaf)
                if len(adj[nb]) == 1:
                    new_leaves.append(nb)
            leaves = new_leaves
        return leaves
