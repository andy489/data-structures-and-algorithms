# https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/

from collections import deque

class Solution:
    def maxTargetNodes(self, edges1: list[list[int]], edges2: list[list[int]]) -> list[int]:
        def build_adj(edges: list[list[int]], size: int) -> list[list[int]]:
            adj = [[] for _ in range(size)]
            for u, v in edges:
                adj[u].append(v)
                adj[v].append(u)
            return adj

        def color_tree(adj: list[list[int]]) -> list[int]:
            size = len(adj)
            color = [-1] * size
            color[0] = 0
            queue = deque([0])
            while queue:
                v = queue.popleft()
                for nb in adj[v]:
                    if color[nb] == -1:
                        color[nb] = 1 - color[v]
                        queue.append(nb)
            return color

        n = len(edges1) + 1
        m = len(edges2) + 1
        adj1 = build_adj(edges1, n)
        adj2 = build_adj(edges2, m)

        color1 = color_tree(adj1)
        color2 = color_tree(adj2)

        c1 = [color1.count(0), color1.count(1)]
        c2 = [color2.count(0), color2.count(1)]
        best2 = max(c2)

        return [c1[color1[i]] + best2 for i in range(n)]
