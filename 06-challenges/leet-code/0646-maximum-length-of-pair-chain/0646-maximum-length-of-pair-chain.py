# https://leetcode.com/problems/maximum-length-of-pair-chain/

class Solution:
    def findLongestChain(self, pairs: list[list[int]]) -> int:
        pairs.sort(key=lambda p: p[1])
        chain_end = float('-inf')
        count = 0
        for left, right in pairs:
            if left > chain_end:
                chain_end = right
                count += 1
        return count
