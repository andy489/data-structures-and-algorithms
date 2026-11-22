# https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/

# Solution: Substring Check — O(n) time, O(1) space
class Solution:
    def checkString(self, s: str) -> bool:
        return "ba" not in s

# Solution 2: Linear Scan — O(n) time, O(1) space
class Solution2:
    def checkString(self, s: str) -> bool:
        seen_b = False

        for c in s:
            if c == 'b':
                seen_b = True
            elif seen_b:
                return False

        return True
