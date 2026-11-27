# https://leetcode.com/problems/critical-connections-in-a-network/

# Solution: Tarjan's Bridge-Finding Algorithm — O(V+E) time, O(V+E) space
class Solution:
    def criticalConnections(self, n: int, connections: list[list[int]]) -> list[list[int]]:
        graph = [[] for _ in range(n)]
        for u, v in connections:
            graph[u].append(v)
            graph[v].append(u)

        disc = [-1] * n
        low = [-1] * n
        bridges = []
        timer = [0]

        def dfs(u: int, parent: int) -> None:
            disc[u] = low[u] = timer[0]
            timer[0] += 1
            for v in graph[u]:
                if v == parent:
                    continue
                if disc[v] == -1:
                    dfs(v, u)
                    low[u] = min(low[u], low[v])
                    if low[v] > disc[u]:
                        bridges.append([u, v])
                else:
                    low[u] = min(low[u], disc[v])

        for i in range(n):
            if disc[i] == -1:
                dfs(i, -1)

        return bridges
