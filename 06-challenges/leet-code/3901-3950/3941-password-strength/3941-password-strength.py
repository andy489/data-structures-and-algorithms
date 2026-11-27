# https://leetcode.com/problems/password-strength/
class Solution:
    def passwordStrength(self, password: str) -> int:
        seen = set()
        strength = 0
        for c in password:
            if c not in seen:
                seen.add(c)
                if c.islower():
                    strength += 1
                elif c.isupper():
                    strength += 2
                elif c.isdigit():
                    strength += 3
                elif c in '!@#$':
                    strength += 5
        return strength
