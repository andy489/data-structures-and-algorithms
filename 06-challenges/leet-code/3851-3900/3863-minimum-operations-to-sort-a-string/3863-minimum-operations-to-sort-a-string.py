# https://leetcode.com/problems/minimum-operations-to-sort-a-string/

class Solution:
    def minimumOperations(self, s: str) -> int:
        n = len(s)
        if n == 1:
            return 0
        if s == ''.join(sorted(s)):
            return 0
        if n == 2:
            return -1
        # Count descents
        return sum(1 for i in range(n - 1) if s[i] > s[i + 1])
