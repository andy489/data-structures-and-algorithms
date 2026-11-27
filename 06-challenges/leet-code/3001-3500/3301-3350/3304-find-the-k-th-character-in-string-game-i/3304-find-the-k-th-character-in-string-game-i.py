# https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/


class Solution:
    def kthCharacter(self, k: int) -> str:
        return chr(ord('a') + bin(k - 1).count('1'))
