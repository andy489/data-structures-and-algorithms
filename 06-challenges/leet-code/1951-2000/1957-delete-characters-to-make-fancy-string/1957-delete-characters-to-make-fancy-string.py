# https://leetcode.com/problems/delete-characters-to-make-fancy-string/
class Solution:
    def makeFancyString(self, s: str) -> str:
        result = []
        for c in s:
            if len(result) >= 2 and result[-1] == c and result[-2] == c:
                continue
            result.append(c)
        return ''.join(result)
