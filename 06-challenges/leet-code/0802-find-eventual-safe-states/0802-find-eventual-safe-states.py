# https://leetcode.com/problems/find-eventual-safe-states/

class Solution:
    def eventualSafeNodes(self, graph: list[list[int]]) -> list[int]:
        n = len(graph)
        color = [0] * n

        def dfs(node):
            if color[node] > 0:
                return color[node] == 2
            color[node] = 1
            for neighbor in graph[node]:
                if not dfs(neighbor):
                    return False
            color[node] = 2
            return True

        return [i for i in range(n) if dfs(i)]
