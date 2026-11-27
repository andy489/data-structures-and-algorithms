# https://leetcode.com/problems/adding-spaces-to-a-string/

# Solution: Two Pointers with List Join — O(n + m) time, O(n + m) space
class Solution:
    def addSpaces(self, s: str, spaces: list[int]) -> str:
        result = []
        j = 0

        for i, c in enumerate(s):
            if j < len(spaces) and i == spaces[j]:
                result.append(' ')
                j += 1
            result.append(c)

        return ''.join(result)
