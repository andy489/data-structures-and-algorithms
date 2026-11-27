# https://leetcode.com/problems/beautiful-arrangement-ii/

class Solution:
    def constructArray(self, n: int, k: int) -> list:
        res = []
        lo, hi = 1, k + 1
        for i in range(k + 1):
            if i % 2 == 0:
                res.append(lo)
                lo += 1
            else:
                res.append(hi)
                hi -= 1
        for i in range(k + 2, n + 1):
            res.append(i)
        return res
