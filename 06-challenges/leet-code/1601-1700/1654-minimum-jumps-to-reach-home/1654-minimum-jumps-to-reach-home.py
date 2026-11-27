# https://leetcode.com/problems/minimum-jumps-to-reach-home/

from collections import deque

class Solution:
    def minimumJumps(self, forbidden: list[int], a: int, b: int, x: int) -> int:
        forbid = set(forbidden)
        limit = x + a + b
        for f in forbidden:
            limit = max(limit, f + a + b)
        visited = [[False, False] for _ in range(limit + 1)]
        queue = deque([(0, 0)])  # pos, last_was_back
        visited[0][0] = True
        steps = 0
        while queue:
            for _ in range(len(queue)):
                pos, back = queue.popleft()
                if pos == x:
                    return steps
                fwd = pos + a
                if fwd <= limit and fwd not in forbid and not visited[fwd][0]:
                    visited[fwd][0] = True
                    queue.append((fwd, 0))
                if not back:
                    bwd = pos - b
                    if bwd > 0 and bwd not in forbid and not visited[bwd][1]:
                        visited[bwd][1] = True
                        queue.append((bwd, 1))
            steps += 1
        return -1
