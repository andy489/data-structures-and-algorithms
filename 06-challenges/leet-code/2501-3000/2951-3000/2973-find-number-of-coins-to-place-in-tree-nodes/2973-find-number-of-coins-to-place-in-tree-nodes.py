# https://leetcode.com/problems/find-number-of-coins-to-place-in-tree-nodes/
class Solution:
    def placedCoins(self, edges: list[list[int]], cost: list[int]) -> list[int]:
        n = len(cost)
        adj = [[] for _ in range(n)]
        for a, b in edges:
            adj[a].append(b)
            adj[b].append(a)
        coins = [0] * n

        def dfs(node: int, parent: int) -> list[int]:
            subtree = [cost[node]]
            for child in adj[node]:
                if child != parent:
                    subtree.extend(dfs(child, node))
            subtree.sort()
            size = len(subtree)
            if size < 3:
                coins[node] = 1
            else:
                opt1 = subtree[-1] * subtree[-2] * subtree[-3]
                opt2 = subtree[0] * subtree[1] * subtree[-1]
                coins[node] = max(0, opt1, opt2)
            if size > 5:
                return subtree[:2] + subtree[-3:]
            return subtree

        dfs(0, -1)
        return coins
