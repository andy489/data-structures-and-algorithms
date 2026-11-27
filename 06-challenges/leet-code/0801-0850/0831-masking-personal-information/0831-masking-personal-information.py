# https://leetcode.com/problems/masking-personal-information/

class Solution:
    def maskPII(self, s: str) -> str:
        s = s.lower()
        if '@' in s:
            at = s.index('@')
            return s[0] + '*****' + s[at-1:]
        digits = [c for c in s if c.isdigit()]
        last4 = ''.join(digits[-4:])
        prefix = '***-***-'
        extra = len(digits) - 10
        if extra > 0:
            prefix = '+' + '*' * extra + '-' + prefix
        return prefix + last4
