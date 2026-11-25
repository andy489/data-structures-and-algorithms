# https://leetcode.com/problems/adding-two-negabinary-numbers/

class Solution:
    def addNegabinary(self, arr1: list[int], arr2: list[int]) -> list[int]:
        i, j, carry = len(arr1)-1, len(arr2)-1, 0
        res = []
        while i >= 0 or j >= 0 or carry:
            a = arr1[i] if i >= 0 else 0
            b = arr2[j] if j >= 0 else 0
            s = a + b + carry
            res.append(s & 1)
            carry = -(s >> 1)
            i -= 1; j -= 1
        while len(res) > 1 and res[-1] == 0:
            res.pop()
        return res[::-1]
