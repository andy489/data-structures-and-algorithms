# https://leetcode.com/problems/split-a-string-in-balanced-strings/

class Solution:
    def balancedStringSplit(self, s: str) -> int:
        balance = res = 0
        for c in s:
            balance += 1 if c == 'R' else -1
            if balance == 0:
                res += 1
        return res
