# https://leetcode.com/problems/rank-transform-of-an-array/

class Solution:
    def arrayRankTransform(self, arr: list[int]) -> list[int]:
        ranks = {v: i+1 for i, v in enumerate(sorted(set(arr)))}
        return [ranks[v] for v in arr]
