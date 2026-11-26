# https://leetcode.com/problems/rearrange-spaces-between-words/

class Solution:
    def reorderSpaces(self, text: str) -> str:
        spaces = text.count(' ')
        words = text.split()
        gaps = len(words) - 1
        between = spaces // gaps if gaps > 0 else 0
        trailing = spaces - between * gaps
        return (' ' * between).join(words) + ' ' * trailing
