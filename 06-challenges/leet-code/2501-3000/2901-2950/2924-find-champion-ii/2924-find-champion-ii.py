# https://leetcode.com/problems/find-champion-ii/

class Solution:
    def findChampion(self, n: int, edges: list[list[int]]) -> int:
        in_degree = [0] * n
        for u, v in edges:
            in_degree[v] += 1
        candidates = [i for i in range(n) if in_degree[i] == 0]
        return candidates[0] if len(candidates) == 1 else -1
