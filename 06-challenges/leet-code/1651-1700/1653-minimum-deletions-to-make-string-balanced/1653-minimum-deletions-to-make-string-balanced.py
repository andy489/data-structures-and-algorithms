# https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/

class Solution:
    def minimumDeletions(self, s: str) -> int:
        b_count = deletions = 0
        for c in s:
            if c == 'b':
                b_count += 1
            else:
                deletions = min(deletions + 1, b_count)
        return deletions
