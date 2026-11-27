# https://leetcode.com/problems/xor-queries-of-a-subarray/

class Solution:
    def xorQueries(self, arr: list[int], queries: list[list[int]]) -> list[int]:
        prefix = [0] * (len(arr) + 1)
        for i, v in enumerate(arr):
            prefix[i+1] = prefix[i] ^ v
        return [prefix[r+1] ^ prefix[l] for l, r in queries]
