# https://leetcode.com/problems/relative-ranks/

class Solution:
    def findRelativeRanks(self, score: list[int]) -> list[str]:
        medals = ["Gold Medal", "Silver Medal", "Bronze Medal"]
        result = [""] * len(score)
        for rank, idx in enumerate(sorted(range(len(score)), key=lambda i: -score[i])):
            result[idx] = medals[rank] if rank < 3 else str(rank + 1)
        return result
