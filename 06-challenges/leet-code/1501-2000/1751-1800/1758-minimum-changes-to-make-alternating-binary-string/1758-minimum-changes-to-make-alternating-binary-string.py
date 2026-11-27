# https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/

class Solution:
    def minOperations(self, s: str) -> int:
        cost0 = sum(1 for i, c in enumerate(s) if int(c) != i % 2)
        return min(cost0, len(s) - cost0)
