# https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
class Solution:
    def numberOfWeakCharacters(self, properties: list[list[int]]) -> int:
        properties.sort(key=lambda x: (-x[0], x[1]))
        max_def = 0
        weak = 0
        for _, d in properties:
            if d < max_def:
                weak += 1
            max_def = max(max_def, d)
        return weak
