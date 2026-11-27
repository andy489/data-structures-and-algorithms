# https://leetcode.com/problems/shortest-path-with-alternating-colors/

from collections import deque

class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: list[list[int]], blueEdges: list[list[int]]) -> list[int]:
        graph = [[] for _ in range(n)]
        for u, v in redEdges:
            graph[u].append((v, 0))
        for u, v in blueEdges:
            graph[u].append((v, 1))

        ans = [-1] * n
        ans[0] = 0
        visited = [[False, False] for _ in range(n)]
        visited[0][0] = visited[0][1] = True

        queue = deque([(0, 0, 0), (0, 1, 0)])  # (node, color, dist)
        while queue:
            node, color, dist = queue.popleft()
            for nb, ec in graph[node]:
                if ec != color and not visited[nb][ec]:
                    visited[nb][ec] = True
                    if ans[nb] == -1:
                        ans[nb] = dist + 1
                    queue.append((nb, ec, dist + 1))
        return ans
