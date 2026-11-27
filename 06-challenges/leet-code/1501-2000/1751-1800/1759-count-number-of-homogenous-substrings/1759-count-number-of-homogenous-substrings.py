# https://leetcode.com/problems/count-number-of-homogenous-substrings/

class Solution:
    def countHomogenous(self, s: str) -> int:
        MOD = 10 ** 9 + 7
        ans = 0
        i = 0
        while i < len(s):
            j = i
            while j < len(s) and s[j] == s[i]:
                j += 1
            k = j - i
            ans = (ans + k * (k + 1) // 2) % MOD
            i = j
        return ans
