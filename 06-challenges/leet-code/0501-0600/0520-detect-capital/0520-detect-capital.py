# https://leetcode.com/problems/detect-capital/

class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        up_count = sum(1 for c in word if c.isupper())
        return up_count == 0 or up_count == len(word) or (up_count == 1 and word[0].isupper())
