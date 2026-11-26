# https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

class Solution:
    def maxLength(self, arr: list[str]) -> int:
        masks = []
        for s in arr:
            m = 0
            for c in s:
                b = 1 << (ord(c) - ord('a'))
                if m & b: m = -1; break
                m |= b
            if m >= 0: masks.append(m)
        dp = {0}
        for m in masks:
            dp |= {d | m for d in dp if not (d & m)}
        return max(bin(x).count('1') for x in dp)
