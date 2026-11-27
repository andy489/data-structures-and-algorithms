# https://leetcode.com/problems/decode-xored-array/

class Solution:
    def decode(self, encoded: list[int], first: int) -> list[int]:
        arr = [first]
        for x in encoded:
            arr.append(arr[-1] ^ x)
        return arr
