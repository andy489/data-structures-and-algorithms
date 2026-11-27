# https://leetcode.com/problems/decode-xored-permutation/

class Solution:
    def decode(self, encoded: list[int]) -> list[int]:
        n = len(encoded) + 1
        total = 0
        for i in range(1, n + 1):
            total ^= i
        rest = 0
        for i in range(1, len(encoded), 2):
            rest ^= encoded[i]
        perm = [total ^ rest]
        for x in encoded:
            perm.append(perm[-1] ^ x)
        return perm
