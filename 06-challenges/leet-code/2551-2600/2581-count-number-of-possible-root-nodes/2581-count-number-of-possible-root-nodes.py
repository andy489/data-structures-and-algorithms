# https://leetcode.com/problems/count-number-of-possible-root-nodes/

from typing import List
from collections import defaultdict

class Solution:
    def rootCount(self, edges: List[List[int]], guesses: List[List[int]], k: int) -> int:
        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        guess_set = {(u, v) for u, v in guesses}
        result = [0]

        def dfs1(node: int, parent: int) -> int:
            cnt = 0
            for child in adj[node]:
                if child == parent:
                    continue
                if (node, child) in guess_set:
                    cnt += 1
                cnt += dfs1(child, node)
            return cnt

        correct0 = dfs1(0, -1)

        def dfs2(node: int, parent: int, cur: int) -> None:
            if cur >= k:
                result[0] += 1
            for child in adj[node]:
                if child == parent:
                    continue
                nxt = cur
                if (node, child) in guess_set:
                    nxt -= 1
                if (child, node) in guess_set:
                    nxt += 1
                dfs2(child, node, nxt)

        dfs2(0, -1, correct0)
        return result[0]
