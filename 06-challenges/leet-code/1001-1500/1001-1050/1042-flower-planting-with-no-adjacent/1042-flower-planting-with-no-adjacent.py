# https://leetcode.com/problems/flower-planting-with-no-adjacent/

class Solution:
    def gardenNoAdj(self, n: int, paths: list[list[int]]) -> list[int]:
        adj = [[] for _ in range(n + 1)]
        for u, v in paths:
            adj[u].append(v)
            adj[v].append(u)
        ans = [0] * (n + 1)
        for i in range(1, n + 1):
            used = {ans[nb] for nb in adj[i]}
            for c in range(1, 5):
                if c not in used:
                    ans[i] = c
                    break
        return ans[1:]
