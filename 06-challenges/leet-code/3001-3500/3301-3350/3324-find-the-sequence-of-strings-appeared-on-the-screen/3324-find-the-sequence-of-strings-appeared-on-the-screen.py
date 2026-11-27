# https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/

class Solution:
    def stringSequence(self, target: str) -> list[str]:
        result = []
        current = []
        for c in target:
            current.append('a')
            result.append(''.join(current))
            while current[-1] != c:
                current[-1] = chr(ord(current[-1]) + 1)
                result.append(''.join(current))
        return result
