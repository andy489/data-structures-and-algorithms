# https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: list[list[int]]) -> list[int]:
        has_incoming = set(e[1] for e in edges)
        return [i for i in range(n) if i not in has_incoming]
