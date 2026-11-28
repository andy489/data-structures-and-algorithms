# https://leetcode.com/problems/longest-special-path-ii/

import sys
sys.setrecursionlimit(100000)

class Solution:
    def longestSpecialPath(self, edges: list[list[int]], nums: list[int]) -> list[int]:
        n = len(nums)
        adj = [[] for _ in range(n)]
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))

        best_len = [0]
        best_nodes = [1]
        last1 = [-1] * (max(nums) + 1)
        last2 = [-1] * (max(nums) + 1)
        prefix = [0] * (n + 2)

        def dfs(node, parent, depth, start):
            v = nums[node]
            prev1, prev2 = last1[v], last2[v]
            last2[v] = last1[v]
            last1[v] = depth
            new_start = start
            if prev2 != -1:
                new_start = max(new_start, prev2 + 1)
            path_len = prefix[depth + 1] - prefix[new_start]
            node_count = depth - new_start + 1
            if path_len > best_len[0] or (path_len == best_len[0] and node_count < best_nodes[0]):
                best_len[0] = path_len
                best_nodes[0] = node_count
            for nb, w in adj[node]:
                if nb != parent:
                    prefix[depth + 2] = prefix[depth + 1] + w
                    dfs(nb, node, depth + 1, new_start)
            last1[v] = prev1
            last2[v] = prev2

        dfs(0, -1, 0, 0)
        return [best_len[0], best_nodes[0]]
