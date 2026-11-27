# https://leetcode.com/problems/special-binary-string/

class Solution:
    def makeLargestSpecial(self, s: str) -> str:
        parts, count, start = [], 0, 0
        for i, c in enumerate(s):
            count += 1 if c == '1' else -1
            if count == 0:
                parts.append('1' + self.makeLargestSpecial(s[start+1:i]) + '0')
                start = i + 1
        return ''.join(sorted(parts, reverse=True))
