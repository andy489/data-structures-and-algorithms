# https://leetcode.com/problems/reverse-only-letters/

class Solution:
    def reverseOnlyLetters(self, s: str) -> str:
        chars = list(s)
        left, right = 0, len(chars) - 1
        while left < right:
            while left < right and not chars[left].isalpha():
                left += 1
            while left < right and not chars[right].isalpha():
                right -= 1
            if left < right:
                chars[left], chars[right] = chars[right], chars[left]
                left += 1
                right -= 1
        return ''.join(chars)
