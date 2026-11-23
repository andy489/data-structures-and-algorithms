# https://leetcode.com/problems/reverse-words-in-a-string-iii/
# Solution: Per-word reverse — O(n) time, O(n) space
class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join(word[::-1] for word in s.split(' '))
