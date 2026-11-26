# https://leetcode.com/problems/permutation-sequence/

class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        fact = [1] * n
        for i in range(1, n):
            fact[i] = fact[i - 1] * i
        digits = list(range(1, n + 1))
        k -= 1
        result = []
        for i in range(n - 1, -1, -1):
            idx = k // fact[i]
            result.append(str(digits[idx]))
            digits.pop(idx)
            k %= fact[i]
        return ''.join(result)
