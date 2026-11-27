# https://leetcode.com/problems/convert-a-number-to-hexadecimal/

class Solution:
    def toHex(self, num: int) -> str:
        if num == 0:
            return "0"
        hex_chars = "0123456789abcdef"
        # Mask to 32 bits (handle negative via two's complement)
        num &= 0xFFFFFFFF
        result = []
        while num:
            result.append(hex_chars[num & 0xf])
            num >>= 4
        return ''.join(reversed(result))
