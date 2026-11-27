# https://leetcode.com/problems/remove-methods-from-project/

from typing import List
from collections import deque


class Solution:
    def remainingMethods(self, n: int, k: int, invocations: List[List[int]]) -> List[int]:
        adj = [[] for _ in range(n)]
        for a, b in invocations:
            adj[a].append(b)

        suspicious = [False] * n
        queue = deque([k])
        suspicious[k] = True
        while queue:
            cur = queue.popleft()
            for nxt in adj[cur]:
                if not suspicious[nxt]:
                    suspicious[nxt] = True
                    queue.append(nxt)

        for a, b in invocations:
            if not suspicious[a] and suspicious[b]:
                return list(range(n))

        return [i for i in range(n) if not suspicious[i]]
