# https://leetcode.com/problems/count-substrings-divisible-by-last-digit/
class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        total = 0
        for r in range(n):
            d = int(s[r])
            if d == 0:
                continue
            num = 0
            pow10 = 1
            for l in range(r, -1, -1):
                digit = int(s[l])
                num = (num + digit * pow10) % d
                pow10 = pow10 * 10 % d
                if num == 0:
                    total += 1
        return total
