# https://leetcode.com/problems/all-paths-from-source-to-target/

class Solution:
    def allPathsSourceTarget(self, graph: list[list[int]]) -> list[list[int]]:
        result = []
        n = len(graph) - 1

        def dfs(node, path):
            if node == n:
                result.append(path[:])
                return
            for nxt in graph[node]:
                path.append(nxt)
                dfs(nxt, path)
                path.pop()

        dfs(0, [0])
        return result
