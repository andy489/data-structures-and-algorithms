# https://leetcode.com/problems/minimum-flips-to-make-binary-string-coherent/

class Solution:
    def minFlips(self, s: str) -> int:
        n = len(s)
        prefix0 = [0] * (n + 1)
        for i in range(n):
            prefix0[i + 1] = prefix0[i] + (1 if s[i] == '0' else 0)
        suffix1 = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            suffix1[i] = suffix1[i + 1] + (1 if s[i] == '1' else 0)
        return min(prefix0[i] + suffix1[i] for i in range(n + 1))
