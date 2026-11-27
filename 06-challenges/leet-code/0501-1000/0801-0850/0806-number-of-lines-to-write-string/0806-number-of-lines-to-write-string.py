# https://leetcode.com/problems/number-of-lines-to-write-string/

class Solution:
    def numberOfLines(self, widths: list[int], s: str) -> list[int]:
        lines, cur = 1, 0
        for c in s:
            w = widths[ord(c) - ord('a')]
            if cur + w > 100:
                lines += 1
                cur = 0
            cur += w
        return [lines, cur]
