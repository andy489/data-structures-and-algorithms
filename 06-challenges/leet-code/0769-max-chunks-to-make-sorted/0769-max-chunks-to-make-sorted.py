# https://leetcode.com/problems/max-chunks-to-make-sorted/

class Solution:
    def maxChunksToSorted(self, arr: list[int]) -> int:
        chunks = max_so_far = 0
        for i, v in enumerate(arr):
            max_so_far = max(max_so_far, v)
            if max_so_far == i:
                chunks += 1
        return chunks
