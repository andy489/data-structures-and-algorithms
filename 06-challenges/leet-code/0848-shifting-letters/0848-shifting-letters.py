# https://leetcode.com/problems/shifting-letters/

class Solution:
    def shiftingLetters(self, s: str, shifts: list[int]) -> str:
        chars = list(s)
        total = 0
        for i in range(len(s) - 1, -1, -1):
            total = (total + shifts[i]) % 26
            chars[i] = chr((ord(chars[i]) - ord('a') + total) % 26 + ord('a'))
        return ''.join(chars)
