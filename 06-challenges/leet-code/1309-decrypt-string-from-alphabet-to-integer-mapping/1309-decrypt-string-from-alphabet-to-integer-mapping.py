# https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/

class Solution:
    def freqAlphabets(self, s: str) -> str:
        res = []
        i = len(s) - 1
        while i >= 0:
            if s[i] == '#':
                num = int(s[i-2:i])
                res.append(chr(ord('a') + num - 1))
                i -= 3
            else:
                res.append(chr(ord('a') + int(s[i]) - 1))
                i -= 1
        return ''.join(reversed(res))
