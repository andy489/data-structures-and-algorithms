# https://leetcode.com/problems/number-of-changing-keys/

class Solution:
    def countKeyChanges(self, s: str) -> int:
        return sum(1 for i in range(1, len(s)) if s[i].lower() != s[i-1].lower())
