# https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/

from collections import deque

class Solution:
    def minInteger(self, num: str, k: int) -> str:
        n = len(num)
        bit = [0] * (n + 1)

        def update(i):
            i += 1
            while i <= n:
                bit[i] += 1
                i += i & (-i)

        def query(i):
            i += 1
            s = 0
            while i > 0:
                s += bit[i]
                i -= i & (-i)
            return s

        pos = [deque() for _ in range(10)]
        for i, ch in enumerate(num):
            pos[int(ch)].append(i)

        result = []
        for i in range(n):
            for d in range(10):
                if not pos[d]:
                    continue
                j = pos[d][0]
                cost = j - query(j - 1)
                if cost <= k:
                    k -= cost
                    pos[d].popleft()
                    update(j)
                    result.append(str(d))
                    break
        return ''.join(result)
