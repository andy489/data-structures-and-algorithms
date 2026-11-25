# https://leetcode.com/problems/add-to-array-form-of-integer/

class Solution:
    def addToArrayForm(self, num: list[int], k: int) -> list[int]:
        res = []
        i = len(num) - 1
        while i >= 0 or k:
            if i >= 0:
                k += num[i]
                i -= 1
            res.append(k % 10)
            k //= 10
        return res[::-1]
