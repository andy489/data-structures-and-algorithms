# https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

class Solution:
    def maxChunksToSorted(self, arr: list[int]) -> int:
        n = len(arr)
        left_max = [0] * n
        right_min = [0] * n
        left_max[0] = arr[0]
        for i in range(1, n):
            left_max[i] = max(left_max[i-1], arr[i])
        right_min[-1] = arr[-1]
        for i in range(n-2, -1, -1):
            right_min[i] = min(right_min[i+1], arr[i])
        return 1 + sum(left_max[i] <= right_min[i+1] for i in range(n-1))
