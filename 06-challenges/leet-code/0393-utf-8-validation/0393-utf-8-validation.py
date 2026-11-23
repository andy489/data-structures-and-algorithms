# https://leetcode.com/problems/utf-8-validation/

class Solution:
    def validUtf8(self, data: list[int]) -> bool:
        continuations = 0
        for b in data:
            b &= 0xFF
            if continuations > 0:
                if (b & 0xC0) != 0x80:
                    return False
                continuations -= 1
            elif (b & 0x80) == 0:
                continuations = 0
            elif (b & 0xE0) == 0xC0:
                continuations = 1
            elif (b & 0xF0) == 0xE0:
                continuations = 2
            elif (b & 0xF8) == 0xF0:
                continuations = 3
            else:
                return False
        return continuations == 0
