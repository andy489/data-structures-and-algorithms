# https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        total = 3 * (1 << (n - 1))
        if k > total:
            return ""
        res = []
        prev = ''
        for i in range(n):
            per_char = 1 << (n - 1 - i)
            for c in 'abc':
                if c == prev:
                    continue
                if per_char >= k:
                    res.append(c)
                    prev = c
                    break
                k -= per_char
        return ''.join(res)
