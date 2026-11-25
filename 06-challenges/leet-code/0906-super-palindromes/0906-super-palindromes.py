# https://leetcode.com/problems/super-palindromes/

class Solution:
    def superpalindromesInRange(self, left: str, right: str) -> int:
        L, R = int(left), int(right)
        count = 0
        def is_pal(x):
            s = str(x)
            return s == s[::-1]
        for k in range(1, 100000):
            s = str(k)
            # odd
            p = int(s + s[-2::-1])
            sq = p * p
            if sq > R:
                break
            if sq >= L and is_pal(sq):
                count += 1
            # even
            p = int(s + s[::-1])
            sq = p * p
            if sq > R:
                break
            if sq >= L and is_pal(sq):
                count += 1
        return count
