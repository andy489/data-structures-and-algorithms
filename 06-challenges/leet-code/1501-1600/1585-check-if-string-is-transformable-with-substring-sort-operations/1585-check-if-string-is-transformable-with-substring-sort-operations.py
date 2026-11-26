# https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/

from collections import deque

class Solution:
    def isTransformable(self, s: str, t: str) -> bool:
        pos = [deque() for _ in range(10)]
        for i, c in enumerate(s):
            pos[int(c)].append(i)
        for c in t:
            d = int(c)
            if not pos[d]:
                return False
            idx = pos[d][0]
            for smaller in range(d):
                if pos[smaller] and pos[smaller][0] < idx:
                    return False
            pos[d].popleft()
        return True
