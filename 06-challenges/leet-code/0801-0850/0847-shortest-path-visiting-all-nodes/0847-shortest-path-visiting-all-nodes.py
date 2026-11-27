# https://leetcode.com/problems/shortest-path-visiting-all-nodes/

from collections import deque

class Solution:
    def shortestPathLength(self, graph: list[list[int]]) -> int:
        n = len(graph)
        full = (1 << n) - 1
        queue = deque()
        visited = set()
        for i in range(n):
            mask = 1 << i
            queue.append((i, mask, 0))
            visited.add((i, mask))
        while queue:
            node, mask, dist = queue.popleft()
            if mask == full:
                return dist
            for nxt in graph[node]:
                next_mask = mask | (1 << nxt)
                if (nxt, next_mask) not in visited:
                    visited.add((nxt, next_mask))
                    queue.append((nxt, next_mask, dist + 1))
        return -1
