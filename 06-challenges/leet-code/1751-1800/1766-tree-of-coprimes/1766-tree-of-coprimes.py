# https://leetcode.com/problems/tree-of-coprimes/

from math import gcd
from collections import defaultdict

class Solution:
    def getCoprimes(self, nums: list[int], edges: list[list[int]]) -> list[int]:
        n = len(nums)
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        coprimes = {v: [w for w in range(1, 51) if gcd(v, w) == 1] for v in range(1, 51)}

        ans = [-1] * n
        last = defaultdict(list)  # value -> list of (node, depth)

        # Iterative DFS using explicit stack
        visited = [False] * n
        depth = [0] * n
        stack = [(0, False)]  # (node, leaving)
        while stack:
            u, leaving = stack.pop()
            if leaving:
                last[nums[u]].pop()
                continue
            if visited[u]:
                continue
            visited[u] = True
            d = depth[u]
            best_depth, best_node = -1, -1
            for cp in coprimes[nums[u]]:
                if last[cp] and last[cp][-1][1] > best_depth:
                    best_node, best_depth = last[cp][-1]
            ans[u] = best_node
            last[nums[u]].append((u, d))
            stack.append((u, True))  # schedule leave
            for v in graph[u]:
                if not visited[v]:
                    depth[v] = d + 1
                    stack.append((v, False))
        return ans
