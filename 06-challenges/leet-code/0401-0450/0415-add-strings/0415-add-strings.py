# https://leetcode.com/problems/add-strings/

class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        i, j, carry = len(num1) - 1, len(num2) - 1, 0
        digits = []
        while i >= 0 or j >= 0 or carry:
            total = carry
            if i >= 0:
                total += ord(num1[i]) - ord('0')
                i -= 1
            if j >= 0:
                total += ord(num2[j]) - ord('0')
                j -= 1
            digits.append(str(total % 10))
            carry = total // 10
        return ''.join(reversed(digits))
