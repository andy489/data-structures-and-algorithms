# https://leetcode.com/problems/check-adjacent-digit-differences/

class Solution:
    def checkAdjacentDifferences(self, s: str) -> bool:
        return all(abs(int(s[i]) - int(s[i - 1])) <= 2 for i in range(1, len(s)))
