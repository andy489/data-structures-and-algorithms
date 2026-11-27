# https://leetcode.com/problems/evaluate-division/

from collections import deque

class Solution:
    def calcEquation(self, equations: list[list[str]], values: list[float],
                     queries: list[list[str]]) -> list[float]:
        graph: dict[str, dict[str, float]] = {}
        for (a, b), v in zip(equations, values):
            graph.setdefault(a, {})[b] = v
            graph.setdefault(b, {})[a] = 1.0 / v

        def bfs(src: str, dst: str) -> float:
            if src not in graph or dst not in graph:
                return -1.0
            if src == dst:
                return 1.0
            visited = {src: 1.0}
            queue = deque([src])
            while queue:
                node = queue.popleft()
                for nxt, w in graph[node].items():
                    if nxt not in visited:
                        visited[nxt] = visited[node] * w
                        if nxt == dst:
                            return visited[nxt]
                        queue.append(nxt)
            return -1.0

        return [bfs(q[0], q[1]) for q in queries]
