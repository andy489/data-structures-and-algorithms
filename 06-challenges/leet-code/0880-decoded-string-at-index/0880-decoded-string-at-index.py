# https://leetcode.com/problems/decoded-string-at-index/

class Solution:
    def decodeAtIndex(self, s: str, k: int) -> str:
        size = 0
        for c in s:
            size = size * int(c) if c.isdigit() else size + 1
        for c in reversed(s):
            k %= size
            if k == 0 and c.isalpha():
                return c
            size = size // int(c) if c.isdigit() else size - 1
        return ""
