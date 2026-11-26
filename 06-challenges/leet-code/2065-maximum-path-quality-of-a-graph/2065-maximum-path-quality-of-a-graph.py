# https://leetcode.com/problems/maximum-path-quality-of-a-graph/

class Solution:
    def maximalPathQuality(self, values: list[int], edges: list[list[int]], maxTime: int) -> int:
        from collections import defaultdict
        adj = defaultdict(list)
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))
        self.res = 0
        cnt = [0] * len(values)
        cnt[0] = 1
        def dfs(node, time, quality):
            if node == 0:
                self.res = max(self.res, quality)
            for v, w in adj[node]:
                if time + w <= maxTime:
                    cnt[v] += 1
                    dfs(v, time + w, quality + (values[v] if cnt[v] == 1 else 0))
                    cnt[v] -= 1
        dfs(0, 0, values[0])
        return self.res
