# https://leetcode.com/problems/length-of-last-word/

# Solution: Reverse Scan — O(n) time, O(1) space
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        i, count = len(s) - 1, 0
        while i >= 0 and s[i] == ' ':
            i -= 1
        while i >= 0 and s[i] != ' ':
            count += 1
            i -= 1
        return count
