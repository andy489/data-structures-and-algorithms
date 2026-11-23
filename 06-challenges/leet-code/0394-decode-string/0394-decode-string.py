# https://leetcode.com/problems/decode-string/

class Solution:
    def decodeString(self, s: str) -> str:
        stack: list[tuple[str, int]] = []
        current = ""
        k = 0
        for c in s:
            if c.isdigit():
                k = k * 10 + int(c)
            elif c == '[':
                stack.append((current, k))
                current = ""
                k = 0
            elif c == ']':
                prev, times = stack.pop()
                current = prev + current * times
            else:
                current += c
        return current
