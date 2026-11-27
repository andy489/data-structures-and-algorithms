# https://leetcode.com/problems/1-bit-and-2-bit-characters/

class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        i = 0
        while i < len(bits) - 1:
            i += 2 if bits[i] == 1 else 1
        return i == len(bits) - 1
