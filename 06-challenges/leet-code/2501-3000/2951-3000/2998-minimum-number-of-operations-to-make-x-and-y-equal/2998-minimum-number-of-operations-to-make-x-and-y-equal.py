# https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/
from collections import deque

class Solution:
    def minimumOperationsToMakeEqual(self, x: int, y: int) -> int:
        if x <= y:
            return y - x
        queue = deque([(x, 0)])
        visited = {x}
        while queue:
            val, dist = queue.popleft()
            if val == y:
                return dist
            neighbors = [val - 1, val + 1]
            if val % 5 == 0:
                neighbors.append(val // 5)
            if val % 11 == 0:
                neighbors.append(val // 11)
            for nxt in neighbors:
                if nxt >= 1 and nxt not in visited and nxt <= x + 11:
                    visited.add(nxt)
                    queue.append((nxt, dist + 1))
        return -1
