# https://leetcode.com/problems/numbers-with-same-consecutive-differences/

class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> list[int]:
        cur = list(range(1, 10))
        for _ in range(n - 1):
            nxt = []
            for num in cur:
                last = num % 10
                if last + k <= 9:
                    nxt.append(num * 10 + last + k)
                if k != 0 and last - k >= 0:
                    nxt.append(num * 10 + last - k)
            cur = nxt
        return cur
