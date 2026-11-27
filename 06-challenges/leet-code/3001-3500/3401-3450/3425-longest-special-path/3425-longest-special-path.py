# https://leetcode.com/problems/longest-special-path/

from collections import defaultdict

class Solution:
    def longestSpecialPath(self, edges: list[list[int]], nums: list[int]) -> list[int]:
        n = len(nums)
        adj = defaultdict(list)
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))

        best_len = 0
        best_nodes = 1
        prefix_dist = [0] * (n + 1)
        last_depth = {}  # value -> depth of last occurrence on current path

        def dfs(node: int, parent: int, depth: int, start_depth: int) -> None:
            nonlocal best_len, best_nodes
            val = nums[node]
            prev_depth = last_depth.get(val, -1)
            new_start = max(start_depth, prev_depth + 1)
            path_length = prefix_dist[depth] - prefix_dist[new_start]
            node_count = depth - new_start + 1
            if path_length > best_len or (path_length == best_len and node_count < best_nodes):
                best_len = path_length
                best_nodes = node_count
            last_depth[val] = depth
            for nb, w in adj[node]:
                if nb != parent:
                    prefix_dist[depth + 1] = prefix_dist[depth] + w
                    dfs(nb, node, depth + 1, new_start)
            last_depth[val] = prev_depth
            if prev_depth == -1:
                last_depth.pop(val, None)

        dfs(0, -1, 0, 0)
        return [best_len, best_nodes]
