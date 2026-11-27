# https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

from collections import defaultdict

class Solution:
    def restoreArray(self, adjacentPairs: list[list[int]]) -> list[int]:
        adj = defaultdict(list)
        for u, v in adjacentPairs:
            adj[u].append(v)
            adj[v].append(u)
        n = len(adjacentPairs) + 1
        result = [0] * n
        for key in adj:
            if len(adj[key]) == 1:
                result[0] = key
                break
        result[1] = adj[result[0]][0]
        for i in range(2, n):
            prev, cur = result[i - 2], result[i - 1]
            neighbors = adj[cur]
            result[i] = neighbors[1] if neighbors[0] == prev else neighbors[0]
        return result
