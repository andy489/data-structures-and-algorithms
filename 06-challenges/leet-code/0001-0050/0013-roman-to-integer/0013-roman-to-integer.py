# https://leetcode.com/problems/roman-to-integer/

class Solution:
    def romanToInt(self, s: str) -> int:
        T = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        res = T[s[-1]]

        for i in range(len(s) - 2, -1, -1):
            if T[s[i]] < T[s[i + 1]]:
                res -= T[s[i]]
            else:
                res += T[s[i]]

        return res
