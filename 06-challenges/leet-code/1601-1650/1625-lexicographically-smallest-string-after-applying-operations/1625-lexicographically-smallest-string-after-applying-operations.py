# https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/

from collections import deque

class Solution:
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        visited = {s}
        q = deque([s])
        ans = s
        while q:
            cur = q.popleft()
            if cur < ans:
                ans = cur
            added = ''.join(
                str((int(c) + a) % 10) if i % 2 == 1 else c
                for i, c in enumerate(cur)
            )
            rotated = cur[-b:] + cur[:-b]
            for nxt in (added, rotated):
                if nxt not in visited:
                    visited.add(nxt)
                    q.append(nxt)
        return ans
