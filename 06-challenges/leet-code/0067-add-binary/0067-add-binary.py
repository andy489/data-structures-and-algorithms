# https://leetcode.com/problems/add-binary/

# Solution: Right-to-left scan with carry — O(n) time, O(n) space
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        res = []
        i, j, carry = len(a) - 1, len(b) - 1, 0
        while i >= 0 or j >= 0 or carry:
            s = carry
            if i >= 0:
                s += int(a[i]); i -= 1
            if j >= 0:
                s += int(b[j]); j -= 1
            res.append(str(s % 2))
            carry = s // 2
        return ''.join(reversed(res))
