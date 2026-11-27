# https://leetcode.com/problems/detonate-the-maximum-bombs/

# Solution: BFS on Directed Graph — O(n^3) time, O(n^2) space
class Solution:
    def maximumDetonation(self, bombs: list[list[int]]) -> int:
        n = len(bombs)
        graph = [[] for _ in range(n)]

        for i in range(n):
            xi, yi, ri = bombs[i]
            for j in range(n):
                if i == j:
                    continue
                dx = bombs[j][0] - xi
                dy = bombs[j][1] - yi
                if dx * dx + dy * dy <= ri * ri:
                    graph[i].append(j)

        def bfs(start):
            visited = {start}
            queue = [start]
            for cur in queue:
                for nxt in graph[cur]:
                    if nxt not in visited:
                        visited.add(nxt)
                        queue.append(nxt)
            return len(visited)

        return max(bfs(i) for i in range(n))
