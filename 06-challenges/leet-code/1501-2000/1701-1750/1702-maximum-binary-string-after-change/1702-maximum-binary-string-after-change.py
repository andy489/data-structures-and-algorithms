# https://leetcode.com/problems/maximum-binary-string-after-change/

class Solution:
    def maximumBinaryString(self, binary: str) -> str:
        first_zero = binary.find('0')
        if first_zero == -1:
            return binary
        zeros = binary[first_zero:].count('0')
        n = len(binary)
        result = ['1'] * n
        result[first_zero + zeros - 1] = '0'
        return ''.join(result)
