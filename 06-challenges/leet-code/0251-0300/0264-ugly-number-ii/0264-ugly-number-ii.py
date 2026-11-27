# https://leetcode.com/problems/ugly-number-ii/

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ugly = [1] * n
        p2 = p3 = p5 = 0
        for i in range(1, n):
            nxt = min(ugly[p2] * 2, ugly[p3] * 3, ugly[p5] * 5)
            ugly[i] = nxt
            if nxt == ugly[p2] * 2:
                p2 += 1
            if nxt == ugly[p3] * 3:
                p3 += 1
            if nxt == ugly[p5] * 5:
                p5 += 1
        return ugly[n - 1]
