# https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/

class Solution:
    def maxEqualRowsAfterFlips(self, matrix: list[list[int]]) -> int:
        from collections import Counter
        freq = Counter()
        for row in matrix:
            flip = row[0]
            key = tuple(v ^ flip for v in row)
            freq[key] += 1
        return max(freq.values())
