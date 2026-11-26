# https://leetcode.com/problems/reformat-the-string/

class Solution:
    def reformat(self, s: str) -> str:
        digits = [c for c in s if c.isdigit()]
        letters = [c for c in s if c.isalpha()]
        if abs(len(digits) - len(letters)) > 1:
            return ""
        if len(letters) > len(digits):
            digits, letters = letters, digits
        res = []
        for i, d in enumerate(digits):
            res.append(d)
            if i < len(letters):
                res.append(letters[i])
        return ''.join(res)
